package com.ornitorrincosystems.meusisteminha;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ornitorrincosystems.meusisteminha.entities.People;
import com.ornitorrincosystems.meusisteminha.repositories.PeopleRepository;

@SpringBootApplication
public class MeusisteminhaApplication implements CommandLineRunner {
	
	@Autowired
	PeopleRepository peopleRepo;

	public static void main(String[] args) {
		SpringApplication.run(MeusisteminhaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		People p1 = new People(null, "Fabio de Oliveira Prudencio", "07138744900", null, null, "47992090158", "fabio.oliveira.prudencio@gmail.com");
		People p2 = new People(null, "Giulia Grasielle Lütke", null, null, null, null, "giulialutke@gmail.com");
		
		peopleRepo.saveAll(Arrays.asList(p1,p2));
		
	}

}
