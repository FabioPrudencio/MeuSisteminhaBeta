package com.ornitorrincosystems.meusisteminha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ornitorrincosystems.meusisteminha.medical.entities.ExamType;

@Repository
public interface ExamTypeRepository extends JpaRepository<ExamType, Integer> {

}
