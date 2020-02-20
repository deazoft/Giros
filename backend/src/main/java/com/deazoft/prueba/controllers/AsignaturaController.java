package com.deazoft.prueba.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deazoft.prueba.persistence.model.Asignatura;
import com.deazoft.prueba.persistence.model.Docente;
import com.deazoft.prueba.persistence.repository.IAsignaturaRepository;
import com.deazoft.prueba.persistence.repository.IDocenteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@CrossOrigin
public class AsignaturaController {

	@Autowired
	IAsignaturaRepository repoAsignatura;
	@Autowired
	IDocenteRepository repoDocente;
	Gson objGson = new GsonBuilder().setPrettyPrinting().create();

	@RequestMapping(method = RequestMethod.GET, path = "/asignaturas/get", produces = "application/json")
	public @ResponseBody String Estudiantes() {

		List<Asignatura> asignatura = (List<Asignatura>) repoAsignatura.findAll();
		return objGson.toJson(asignatura);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/asignaturas/get/{id}", produces = "application/json")
	public @ResponseBody String EstudiantesbyId(@PathVariable int id) {
		return objGson.toJson(repoAsignatura.findById(id));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/asignaturas/PUT", produces = "application/json")
	public @ResponseBody String EstudiantePUT(@RequestBody Asignatura asignatura) {

		Optional<Docente> docente = repoDocente.findById(asignatura.getDocente().getId());
		asignatura.setDocente(docente.get());
		asignatura.setId_docente(docente.get().getId());
		repoAsignatura.save(asignatura);
		return objGson.toJson(asignatura);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/asignaturas/del", produces = "application/json")
	public @ResponseBody String EstudianteDel(@RequestBody Asignatura asignatura) {

		repoAsignatura.delete(asignatura);
		return objGson.toJson("Borrado Exitoso");
	}

	@RequestMapping(method = RequestMethod.POST, path = "/asignaturas/save", produces = "application/json")
	public @ResponseBody String EstudianteSave(@RequestBody Asignatura asignatura) {
		repoAsignatura.save(asignatura);
		return objGson.toJson(asignatura);
	}

}
