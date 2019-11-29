package com.deazoft.prueba;

import java.util.EnumSet;
import java.util.Scanner;

import javax.faces.webapp.FacesServlet;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.deazoft.prueba")
@EnableJpaRepositories("com.deazoft.prueba.persistence.repository")
@EntityScan("com.deazoft.prueba.persistence.model")
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
		
		 System.out.println("Press 'Enter' to terminate");
	        new Scanner(System.in).nextLine();
	        System.out.println("Exiting");
	        System.exit(1);
	}
	
	

}
