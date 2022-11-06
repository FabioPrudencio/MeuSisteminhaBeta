package com.ornitorrincosystems.meusisteminha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ornitorrincosystems.meusisteminha.entities.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

}
