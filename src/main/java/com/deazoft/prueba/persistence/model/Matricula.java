package com.deazoft.prueba.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//@OneToOne (targetEntity = Estudiante.class,mappedBy = "est")
	private Integer est;

	public Integer getEst() {
		return est;
	}

	public void setEst(Integer est) {
		this.est = est;
	}
	
	

}
