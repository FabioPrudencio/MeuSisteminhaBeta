package com.ornitorrincosystems.meusisteminha.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ornitorrincosystems.meusisteminha.entities.People;
import com.ornitorrincosystems.meusisteminha.services.PeopleService;

@RestController
@RequestMapping(value="/peoples")
public class PeopleResource {
	
	@Autowired
	PeopleService serv;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)	
	public ResponseEntity<People> findById(@PathVariable Integer id) {
		People obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<People> listAll() {
		
		People p1 = new People(1, "Fabio de Oliveira Prudencio", "07138744900", null, null, "47992090158", "fabio.oliveira.prudencio@gmail.com");
		People p2 = new People(2, "Giulia Grasielle Lütke", null, null, null, null, "giulialutke@gmail.com");
		
		List<People> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		return list;
	}
	
}
