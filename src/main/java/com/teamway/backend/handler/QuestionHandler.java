package com.teamway.backend.handler;

import com.teamway.backend.api.dto.QuestionApiModel;
import com.teamway.backend.api.dto.ScoreApiModel;
import com.teamway.backend.domain.model.Answer;
import com.teamway.backend.domain.model.Question;
import com.teamway.backend.domain.repository.AnswerJpaRepository;
import com.teamway.backend.domain.repository.QuestionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.LongSummaryStatistics;

@RequiredArgsConstructor
@Component
public class QuestionHandler {

    private final QuestionJpaRepository questionJpaRepository;

    private final AnswerJpaRepository jpaRepository;

    private final ScoreService scoreService;

    private final ApiMapper apiMapper;

    public List<QuestionApiModel> prepareQuestionList() {
        List<Question> questions = questionJpaRepository.findAll();
        return apiMapper.map(questions);
    }

    public ScoreApiModel calculateScore(Collection<Long> answers) {
        List<Answer> answerList = jpaRepository.findAllById(answers);
        LongSummaryStatistics scores = scoreService.calculate(answerList);
        return new ScoreApiModel(scores.getSum(), scores.getSum() >= 6);
    }


}
