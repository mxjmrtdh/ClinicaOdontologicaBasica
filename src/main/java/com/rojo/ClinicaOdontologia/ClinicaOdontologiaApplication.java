package com.rojo.ClinicaOdontologia;

import com.rojo.ClinicaOdontologia.db.H2Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologiaApplication {

	public static void main(String[] args) {
		H2Connection.crearTablas();
		SpringApplication.run(ClinicaOdontologiaApplication.class, args);
	}

}
