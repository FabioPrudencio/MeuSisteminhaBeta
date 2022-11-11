package com.ornitorrincosystems.meusisteminha;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ornitorrincosystems.meusisteminha.entities.Address;
import com.ornitorrincosystems.meusisteminha.entities.City;
import com.ornitorrincosystems.meusisteminha.entities.Person;
import com.ornitorrincosystems.meusisteminha.entities.State;
import com.ornitorrincosystems.meusisteminha.entities.enums.PersonType;
import com.ornitorrincosystems.meusisteminha.medical.entities.Exam;
import com.ornitorrincosystems.meusisteminha.medical.entities.ExamType;
import com.ornitorrincosystems.meusisteminha.repositories.AddressRepository;
import com.ornitorrincosystems.meusisteminha.repositories.CityRepository;
import com.ornitorrincosystems.meusisteminha.repositories.ExamRepository;
import com.ornitorrincosystems.meusisteminha.repositories.ExamTypeRepository;
import com.ornitorrincosystems.meusisteminha.repositories.PersonRepository;
import com.ornitorrincosystems.meusisteminha.repositories.StateRepository;

@SpringBootApplication
public class MeusisteminhaApplication implements CommandLineRunner {
	
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	ExamTypeRepository examTypeRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;

	public static void main(String[] args) {
		SpringApplication.run(MeusisteminhaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ExamType examType1 = new ExamType(null, "Exame de Sangue", 2.0, 8.0, null);
		ExamType examType2 = new ExamType(null, "Colonoscopia", null, null, null);
		
		Exam exam1 = new Exam(null, "Birrubina", null, 4.0, null);
		Exam exam2 = new Exam(null, "COVID19", null, null, "negativo");
		Exam exam3 = new Exam(null, "Colonoscopia", null, null, "negativo");
		
		examType1.getExams().addAll(Arrays.asList(exam1,exam2));
		examType2.getExams().addAll(Arrays.asList(exam3));
		
		exam1.getExamTypes().addAll(Arrays.asList(examType1));
		exam2.getExamTypes().addAll(Arrays.asList(examType1));
		exam3.getExamTypes().addAll(Arrays.asList(examType2));
		
		examTypeRepo.saveAll(Arrays.asList(examType1,examType2));
		examRepo.saveAll(Arrays.asList(exam1, exam2, exam3));
		
		
		
		Person p1 = new Person(null, "Fabio de Oliveira Prudencio", "07138844900", null, null, "fabio.oliveira.prudencio@gmail.com", PersonType.FISICPERSON);
		Person p2 = new Person(null, "Giulia Grasielle Lütke", null, null, null, "giulialutke@gmail.com", PersonType.FISICPERSON);
		
		Map<String, String> emails = new HashMap<>();
		
		emails.put("Personal", "fabio@gmail.com");
		emails.put("Work", "fabio@danica.com");
		
		p1.getEmails().putAll(emails);
		
		Map<String, String> phones1 = new HashMap<>();
		phones1.put("CelPhone", "999994444");
		phones1.put("Work Phone", "34999999");
		
		p1.getPhoneNumbers().putAll(phones1);
		
		Map<String, String> phones2 = new HashMap<>();
		phones2.put("CelPhone", "999994444");
		phones2.put("Work Phone", "34999999");
		
		p2.getPhoneNumbers().putAll(phones2);
						
		State state1 = new State(null, "Santa Catarina");
		State state2 = new State(null, "São Paulo");
		City city1 = new City(null, "Joinville", state1);
		City city2 = new City(null, "São Paulo", state2);
		
		stateRepo.saveAll(Arrays.asList(state1,state2));
		cityRepo.saveAll(Arrays.asList(city1,city2));
		
		Address adr1 = new Address(null, "Rua São João", "429", null, "Petrópolis", "89208-744", city1, p1);
		Address adr2 = new Address(null, "Rua Pedro Rosa", "300", null, "Liberdade", "89000-500", city2, p1);
		Address adr3 = new Address(null, "Rua dos Pedreiros", "501", null, "Petrópolis", "89980-744", city2, p2);
		
		p1.getAdresses().addAll(Arrays.asList(adr1,adr2));
		p2.getAdresses().add(adr3);
		
		state1.getCities().add(city1);
		state2.getCities().add(city2);
		
		personRepo.saveAll(Arrays.asList(p1,p2));
		addressRepo.saveAll(Arrays.asList(adr1,adr2,adr3));
		
	}

}
