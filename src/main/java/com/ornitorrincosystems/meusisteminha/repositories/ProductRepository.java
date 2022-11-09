package com.ornitorrincosystems.meusisteminha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ornitorrincosystems.meusisteminha.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
