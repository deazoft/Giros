package com.deazoft.prueba.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.deazoft.prueba.persistence.model.Estudiante;

public interface IEstudianteRepository  extends CrudRepository<Estudiante, Integer> {

}
