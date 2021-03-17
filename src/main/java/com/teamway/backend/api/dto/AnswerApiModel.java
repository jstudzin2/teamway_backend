package com.teamway.backend.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerApiModel {

    private Long id;

    private String value;
}
