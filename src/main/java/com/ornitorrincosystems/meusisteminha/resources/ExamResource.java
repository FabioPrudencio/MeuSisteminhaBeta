package com.ornitorrincosystems.meusisteminha.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ornitorrincosystems.meusisteminha.entities.Exam;
import com.ornitorrincosystems.meusisteminha.services.ExamService;

@RestController
@RequestMapping(value="/exams")
public class ExamResource {
	
	@Autowired
	ExamService serv;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)	
	public ResponseEntity<Exam> findById(@PathVariable Integer id) {
		Exam obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Exam> listAll() {
		
		Exam exam1 = new Exam();
		Exam exam2 = new Exam();
		
		List<Exam> list = new ArrayList<>();
		list.add(exam1);
		list.add(exam2);
		
		return list;
	}
	
}
