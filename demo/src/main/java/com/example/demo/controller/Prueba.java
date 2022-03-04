package com.example.demo.controller;


import com.example.demo.domain.Persona;
import com.example.demo.service.PersonaServiceImpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class Prueba {

    //identamos la interface personaDAO de la base de datos dentro del controlador
    @Autowired
    private PersonaServiceImpo personaServiceImpo;

    @GetMapping("/")
    public String inicio(Model model){

       var personas = personaServiceImpo.listarPersonas();
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for(var p: personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "hola";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaServiceImpo.guardarPersona(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
        persona = personaServiceImpo.buscarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{id_persona}")
    public String eliminar(Persona persona){
        personaServiceImpo.borrarPersonas(persona);
        return "redirect:/";
    }
}
