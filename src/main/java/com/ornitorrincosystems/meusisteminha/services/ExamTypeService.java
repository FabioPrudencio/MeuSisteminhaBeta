package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.medical.entities.ExamType;
import com.ornitorrincosystems.meusisteminha.repositories.ExamTypeRepository;
import com.ornitorrincosystems.meusisteminha.services.exceptions.ObjectNotFoundException;

@Service
public class ExamTypeService {

	@Autowired
	ExamTypeRepository repo;

	public ExamType findById(Integer id) {
		Optional<ExamType> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object don't finded! Id: " + id + ", Type: " + ExamType.class.getName()));
	}

}
