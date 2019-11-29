package com.deazoft.prueba.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.deazoft.prueba.persistence.model.Docente;


public interface IDocenteRepository  extends CrudRepository<Docente, Integer> {

}
