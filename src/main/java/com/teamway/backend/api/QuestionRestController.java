package com.teamway.backend.api;

import com.teamway.backend.api.dto.QuestionApiModel;
import com.teamway.backend.api.dto.ScoreApiModel;
import com.teamway.backend.handler.QuestionHandler;
import com.teamway.backend.validation.RequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("/questions")
@RequiredArgsConstructor
@RestController
public class QuestionRestController {

    private final QuestionHandler handler;

    private final RequestValidator validator;

    @GetMapping
    public ResponseEntity<List<QuestionApiModel>> prepareQuestionList() {
        return ok(handler.prepareQuestionList());
    }

    @PostMapping(value = "/calculateScore",  consumes = "application/json")
    public ResponseEntity<ScoreApiModel> calculateScore(@RequestBody Map<Long,Long> body) {
        validator.validate(body);
        return ok(handler.calculateScore(body.values()));
    }
}
