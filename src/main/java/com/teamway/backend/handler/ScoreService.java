package com.teamway.backend.handler;

import com.teamway.backend.domain.model.Answer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    @Value("${scoring.score}")
    private Integer introverticScore;

    public LongSummaryStatistics calculate(List<Answer> answerList) {
        return answerList
                .stream()
                .map(Answer::getScore)
                .collect(Collectors.summarizingLong(Long::longValue));
    }

    public boolean isIntrovertic(long sum) {
        return sum > introverticScore;
    }
}
