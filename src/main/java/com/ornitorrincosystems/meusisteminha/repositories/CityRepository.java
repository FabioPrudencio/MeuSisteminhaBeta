package com.ornitorrincosystems.meusisteminha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ornitorrincosystems.meusisteminha.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
