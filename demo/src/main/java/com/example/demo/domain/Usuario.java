package com.example.demo.domain;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    private final static long serializableVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotEmpty
    @JoinColumn(name = "username")
    private String username;

    @NotEmpty
    @JoinColumn(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;
}
