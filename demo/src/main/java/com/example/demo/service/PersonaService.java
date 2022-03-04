package com.example.demo.service;

import com.example.demo.domain.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> listarPersonas();

    public void borrarPersonas(Persona persona);

    public void guardarPersona(Persona persona);

    public Persona buscarPersona(Persona persona);

}
