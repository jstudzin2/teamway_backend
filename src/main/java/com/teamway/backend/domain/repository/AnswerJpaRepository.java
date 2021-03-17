package com.teamway.backend.domain.repository;

import com.teamway.backend.domain.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {
}
