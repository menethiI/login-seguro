package br.com.app.login_seguro.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import br.com.app.login_seguro.repository.UserRepository;

import java.util.stream.Collectors;

@Service
public class DetailsService implements UserDetailsService {

    private final UserRepository repository;

    public DetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        br.com.app.login_seguro.model.User user = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new User(
                user.getEmail(),
                user.getSenha(),
                user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toSet())
        );
    }
}