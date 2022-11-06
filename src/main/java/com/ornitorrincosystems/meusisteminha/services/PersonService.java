package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.entities.Person;
import com.ornitorrincosystems.meusisteminha.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repo;
	
	public Person findById(Integer id) {
		Optional<Person> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
