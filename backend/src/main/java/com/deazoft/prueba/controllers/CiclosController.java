package com.deazoft.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deazoft.prueba.persistence.model.Ciclos;

import com.deazoft.prueba.persistence.repository.ICiclosRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class CiclosController {

	@Autowired
	ICiclosRepository repoCiclo;
	Gson objGson = new GsonBuilder().setPrettyPrinting().create();

	@RequestMapping(method = RequestMethod.GET, path = "/ciclos/get", produces = "application/json")
	public @ResponseBody String Estudiantes() {

		List<Ciclos> ciclos = (List<Ciclos>) repoCiclo.findAll();
		return objGson.toJson(ciclos);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/ciclos/get/{id}", produces = "application/json")
	public @ResponseBody String EstudiantesbyId(@PathVariable int id) {
		return objGson.toJson(repoCiclo.findById(id));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/ciclos/PUT", produces = "application/json")
	public @ResponseBody String EstudiantePUT(@RequestBody Ciclos ciclo) {

		repoCiclo.save(ciclo);
		return objGson.toJson(ciclo);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/ciclos/del", produces = "application/json")
	public @ResponseBody String EstudianteDel(@RequestBody Ciclos ciclo) {

		repoCiclo.delete(ciclo);
		return objGson.toJson("Borrado Exitoso");
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ciclos/save", produces = "application/json")
	public @ResponseBody String EstudianteSave(@RequestBody Ciclos ciclo) {
		repoCiclo.save(ciclo);
		return objGson.toJson(ciclo);
	}

}
