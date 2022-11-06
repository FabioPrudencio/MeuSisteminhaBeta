package com.ornitorrincosystems.meusisteminha;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ornitorrincosystems.meusisteminha.entities.Exam;
import com.ornitorrincosystems.meusisteminha.entities.ExamType;
import com.ornitorrincosystems.meusisteminha.entities.Person;
import com.ornitorrincosystems.meusisteminha.repositories.ExamRepository;
import com.ornitorrincosystems.meusisteminha.repositories.ExamTypeRepository;
import com.ornitorrincosystems.meusisteminha.repositories.PersonRepository;

@SpringBootApplication
public class MeusisteminhaApplication implements CommandLineRunner {
	
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	ExamTypeRepository examTypeRepo;

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
		
		Person p1 = new Person(null, "Fabio de Oliveira Prudencio", "07138744900", null, null, "47992090158", "fabio.oliveira.prudencio@gmail.com");
		Person p2 = new Person(null, "Giulia Grasielle Lütke", null, null, null, null, "giulialutke@gmail.com");
		
		examTypeRepo.saveAll(Arrays.asList(examType1,examType2));
		examRepo.saveAll(Arrays.asList(exam1, exam2, exam3));
		personRepo.saveAll(Arrays.asList(p1,p2));
		
	}

}
