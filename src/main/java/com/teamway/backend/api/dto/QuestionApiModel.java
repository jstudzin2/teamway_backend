package com.teamway.backend.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionApiModel {

    private Long id;

    private String description;

    private List<AnswerApiModel> answers;

}
