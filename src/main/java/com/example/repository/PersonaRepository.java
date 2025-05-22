package com.example.repository;

import com.example.domain.Persona;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
}
