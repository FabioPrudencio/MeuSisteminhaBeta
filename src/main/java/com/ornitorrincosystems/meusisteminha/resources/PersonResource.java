package com.ornitorrincosystems.meusisteminha.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ornitorrincosystems.meusisteminha.entities.Person;
import com.ornitorrincosystems.meusisteminha.services.PersonService;

@RestController
@RequestMapping(value="/peoples")
public class PersonResource {
	
	@Autowired
	PersonService serv;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)	
	public ResponseEntity<Person> findById(@PathVariable Integer id) {
		Person obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> listAll() {
		
		Person p1 = new Person(1, "Fabio de Oliveira Prudencio", "07138744900", null, null, "47992090158", "fabio.oliveira.prudencio@gmail.com");
		Person p2 = new Person(2, "Giulia Grasielle Lütke", null, null, null, null, "giulialutke@gmail.com");
		
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		return list;
	}
	
}
