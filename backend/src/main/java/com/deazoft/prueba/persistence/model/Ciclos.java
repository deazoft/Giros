package com.deazoft.prueba.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ciclos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	int Año;
	
	public int getAño() {
		return Año;
	}
	public void setAño(int año) {
		Año = año;
	}
	public String getCiclo() {
		return Ciclo;
	}
	public void setCiclo(String ciclo) {
		Ciclo = ciclo;
	}
	String Ciclo;

}
