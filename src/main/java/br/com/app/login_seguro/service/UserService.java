package br.com.app.login_seguro.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.app.login_seguro.dto.UserDTO;
import br.com.app.login_seguro.model.User;
import br.com.app.login_seguro.repository.UserRepository;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public void cadastrar(UserDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        User usuario = new User();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(encoder.encode(dto.getSenha()));
        usuario.setRoles(Set.of("USER"));

        repository.save(usuario);
    }
}