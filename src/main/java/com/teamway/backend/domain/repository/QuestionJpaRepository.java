package com.teamway.backend.domain.repository;

import com.teamway.backend.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionJpaRepository extends JpaRepository<Question, Long> {
}
