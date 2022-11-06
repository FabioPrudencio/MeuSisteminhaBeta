package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.entities.ExamType;
import com.ornitorrincosystems.meusisteminha.repositories.ExamTypeRepository;

@Service
public class ExamTypeService {

	@Autowired
	ExamTypeRepository repo;

	public ExamType findById(Integer id) {
		Optional<ExamType> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
