package com.ornitorrincosystems.meusisteminha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ornitorrincosystems.meusisteminha.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
