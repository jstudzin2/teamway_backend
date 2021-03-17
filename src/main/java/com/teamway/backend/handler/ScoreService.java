package com.teamway.backend.handler;

import com.teamway.backend.domain.model.Answer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    public LongSummaryStatistics calculate(List<Answer> answerList) {
        return answerList.stream().map(answer -> answer.getScore()).collect(Collectors.summarizingLong(Long::longValue));
    }
}
