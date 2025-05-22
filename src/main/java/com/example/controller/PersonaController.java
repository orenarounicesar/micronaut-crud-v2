package com.example.controller;

import com.example.domain.Persona;
import com.example.repository.PersonaRepository;
import io.micronaut.http.annotation.*;

import java.util.Optional;

@Controller("/personas")
public class PersonaController {

    private final PersonaRepository repository;

    public PersonaController(PersonaRepository repository) {
        this.repository = repository;
    }

    @Get("/{id}")
    public Optional<Persona> get(Long id) {
        return repository.findById(id);
    }

    @Post
    public Persona save(@Body Persona persona) {
        return repository.save(persona);
    }

    @Put("/{id}")
    public Persona update(Long id, @Body Persona persona) {
        persona.setId(id);
        return repository.update(persona);
    }

    @Delete("/{id}")
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
