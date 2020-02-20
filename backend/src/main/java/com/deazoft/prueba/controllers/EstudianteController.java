package com.deazoft.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deazoft.prueba.persistence.model.Estudiante;
import com.deazoft.prueba.persistence.repository.IEstudianteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@CrossOrigin
public class EstudianteController {
	
	@Autowired
	IEstudianteRepository repoEst;
	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
	
	@RequestMapping(method = RequestMethod.GET, path = "/estudiantes/get",produces = "application/json")
	public @ResponseBody String Estudiantes() {

		List<Estudiante> estudiantes = (List<Estudiante>) repoEst.findAll();
		return objGson.toJson(estudiantes);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/estudiantes/get/{id}",produces = "application/json")
	public @ResponseBody String EstudiantesbyId(@PathVariable int id) {
		return objGson.toJson(repoEst.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/estudiantes/PUT",produces = "application/json")
	public @ResponseBody String EstudiantePUT(@RequestBody Estudiante est) {
		
		repoEst.save(est);
		return objGson.toJson(est);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/estudiantes/del",produces = "application/json")
	public @ResponseBody String EstudianteDel(@RequestBody Estudiante est) {
		
		repoEst.delete(est);
		return objGson.toJson("Borrado Exitoso");
	}
	@RequestMapping(method = RequestMethod.POST, path = "/estudiantes/save",produces = "application/json")
	public @ResponseBody String EstudianteSave(@RequestBody Estudiante est) {
		repoEst.save(est);
		return objGson.toJson(est);
	}

}
