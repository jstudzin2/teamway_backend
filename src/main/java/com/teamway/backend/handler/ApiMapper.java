package com.teamway.backend.handler;

import com.teamway.backend.api.dto.AnswerApiModel;
import com.teamway.backend.api.dto.QuestionApiModel;
import com.teamway.backend.domain.model.Answer;
import com.teamway.backend.domain.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApiMapper {
    public List<QuestionApiModel> map(List<Question> questions) {
        return questions.stream().map(this::map).collect(Collectors.toList());
    }

    private QuestionApiModel map(Question question) {
        return QuestionApiModel.builder()
                .description(question.getDescription())
                .id(question.getId())
                .answers(question.getAnswers() == null ? null : question.getAnswers().stream().map(this::map).collect(Collectors.toList()))
                .build();
    }

    private AnswerApiModel map(Answer answer) {
        return AnswerApiModel.builder()
                .id(answer.getId())
                .value(answer.getValue())
                .build();
    }
}
