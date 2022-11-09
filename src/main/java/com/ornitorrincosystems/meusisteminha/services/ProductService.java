package com.ornitorrincosystems.meusisteminha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ornitorrincosystems.meusisteminha.entities.Product;
import com.ornitorrincosystems.meusisteminha.repositories.ProductRepository;
import com.ornitorrincosystems.meusisteminha.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;

	public Product findById(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object don't finded! Id: " + id + ", Type: " + Product.class.getName()));
	}

}
