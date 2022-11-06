package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.entities.People;
import com.ornitorrincosystems.meusisteminha.repositories.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	PeopleRepository repo;
	
	public People findById(Integer id) {
		Optional<People> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
