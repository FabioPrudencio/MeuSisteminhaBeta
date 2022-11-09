package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.entities.Category;
import com.ornitorrincosystems.meusisteminha.repositories.CategoryRepository;
import com.ornitorrincosystems.meusisteminha.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repo;

	public Category findById(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object don't finded! Id: " + id + ", Type: " + Category.class.getName()));
	}

}
