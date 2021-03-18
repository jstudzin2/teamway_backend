package com.teamway.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class ScoreApiModel {

    private Long myScore;

    private boolean introvert;
}
