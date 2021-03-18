package com.teamway.backend.validation;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RequestValidator {

    public void validate(Map<Long, Long> request) {
        if (request == null || request.isEmpty()) {
            throw new IncorrectDataException("No answers to score");
        }
    }
}
