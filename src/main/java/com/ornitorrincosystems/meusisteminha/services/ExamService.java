package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.medical.entities.Exam;
import com.ornitorrincosystems.meusisteminha.repositories.ExamRepository;
import com.ornitorrincosystems.meusisteminha.services.exceptions.ObjectNotFoundException;

@Service
public class ExamService {

	@Autowired
	ExamRepository repo;

	public Exam findById(Integer id) {
		Optional<Exam> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object don't finded! Id: " + id + ", Type: " + Exam.class.getName()));
	}

}
