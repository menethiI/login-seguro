package br.com.app.login_seguro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String nome;

    private String email;

    private String senha;
    
    private Set<String> roles;
    
}