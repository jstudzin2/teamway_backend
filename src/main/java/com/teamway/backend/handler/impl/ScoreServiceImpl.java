package com.teamway.backend.handler.impl;

import com.teamway.backend.domain.model.Answer;
import com.teamway.backend.handler.ScoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Value("${scoring.score}")
    private Integer introverticScore;

    @Override
    public LongSummaryStatistics calculate(List<Answer> answerList) {
        return answerList
                .stream()
                .map(Answer::getScore)
                .collect(Collectors.summarizingLong(Long::longValue));
    }

    @Override
    public boolean isIntrovertic(long sum) {
        return sum > introverticScore;
    }
}
