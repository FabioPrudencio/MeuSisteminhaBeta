package com.ornitorrincosystems.meusisteminha.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ornitorrincosystems.meusisteminha.entities.Product;
import com.ornitorrincosystems.meusisteminha.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	ProductService serv;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
