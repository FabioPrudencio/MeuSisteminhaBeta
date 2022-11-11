package com.ornitorrincosystems.meusisteminha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ornitorrincosystems.meusisteminha.medical.entities.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
