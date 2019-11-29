package com.deazoft.prueba.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.deazoft.prueba.persistence.model.Asignatura;



public interface IAsignaturaRepository  extends CrudRepository<Asignatura, Integer> {

}
