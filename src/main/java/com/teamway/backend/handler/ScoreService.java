package com.teamway.backend.handler;

import com.teamway.backend.domain.model.Answer;

import java.util.List;
import java.util.LongSummaryStatistics;

public interface ScoreService {
    LongSummaryStatistics calculate(List<Answer> answerList);

    boolean isIntrovertic(long sum);
}
