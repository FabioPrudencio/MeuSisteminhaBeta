package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.entities.Exam;
import com.ornitorrincosystems.meusisteminha.repositories.ExamRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository repo;

	public Exam findById(Integer id) {
		Optional<Exam> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
