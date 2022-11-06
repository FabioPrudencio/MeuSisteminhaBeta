package com.ornitorrincosystems.meusisteminha.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ornitorrincosystems.meusisteminha.entities.ExamType;
import com.ornitorrincosystems.meusisteminha.services.ExamTypeService;

@RestController
@RequestMapping(value = "/examtypes")
public class ExamTypeResource {

	@Autowired
	ExamTypeService serv;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamType> findById(@PathVariable Integer id) {
		ExamType obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
