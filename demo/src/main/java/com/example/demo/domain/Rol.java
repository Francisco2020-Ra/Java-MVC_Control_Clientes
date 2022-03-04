package com.example.demo.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @NotEmpty
    private String nombre;

}
