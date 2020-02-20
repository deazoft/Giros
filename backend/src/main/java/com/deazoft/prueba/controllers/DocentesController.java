package com.deazoft.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.deazoft.prueba.persistence.model.Docente;
import com.deazoft.prueba.persistence.repository.IDocenteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class DocentesController {

	@Autowired
	IDocenteRepository repoDocente;
	
	Gson objGson = new GsonBuilder().setPrettyPrinting().create();

	@RequestMapping(method = RequestMethod.GET, path = "/docentes/get", produces = "application/json")
	public @ResponseBody String Docentes() {

		List<Docente> docentes = (List<Docente>) repoDocente.findAll();
		return objGson.toJson(docentes);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/docentes/get/{id}", produces = "application/json")
	public @ResponseBody String DocentebyId(@PathVariable int id) {
		return objGson.toJson(repoDocente.findById(id));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/docentes/PUT", produces = "application/json")
	public @ResponseBody String DocentePUT(@RequestBody Docente docente) {

		repoDocente.save(docente);
		return objGson.toJson(docente);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/docentes/del", produces = "application/json")
	public @ResponseBody String DocenteDel(@RequestBody Docente docente) {

		repoDocente.delete(docente);
		return objGson.toJson("Borrado Exitoso");
	}

	@RequestMapping(method = RequestMethod.POST, path = "/docentes/save", produces = "application/json")
	public @ResponseBody String DocenteSave(@RequestBody Docente docente) {
		repoDocente.save(docente);
		return objGson.toJson(docente);
	}

}
