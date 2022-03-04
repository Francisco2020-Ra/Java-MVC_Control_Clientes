package com.example.demo.service;

import com.example.demo.dao.PersonaDAO;
import com.example.demo.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpo implements PersonaService{

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDAO.findAll();
    }

    @Override
    @Transactional
    public void borrarPersonas(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    @Transactional
    public void guardarPersona(Persona persona) {
            personaDAO.save(persona);
    }

    @Override
    public Persona buscarPersona(Persona persona) {
        return personaDAO.findById(persona.getId_persona()).orElse(null);
    }
}
