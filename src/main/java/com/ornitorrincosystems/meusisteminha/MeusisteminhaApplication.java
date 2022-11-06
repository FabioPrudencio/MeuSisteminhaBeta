package com.ornitorrincosystems.meusisteminha;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ornitorrincosystems.meusisteminha.entities.Person;
import com.ornitorrincosystems.meusisteminha.repositories.PersonRepository;

@SpringBootApplication
public class MeusisteminhaApplication implements CommandLineRunner {
	
	@Autowired
	PersonRepository personRepo;

	public static void main(String[] args) {
		SpringApplication.run(MeusisteminhaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Person p1 = new Person(null, "Fabio de Oliveira Prudencio", "07138744900", null, null, "47992090158", "fabio.oliveira.prudencio@gmail.com");
		Person p2 = new Person(null, "Giulia Grasielle Lütke", null, null, null, null, "giulialutke@gmail.com");
		
		personRepo.saveAll(Arrays.asList(p1,p2));
		
	}

}
