package com.teamway.backend.validation;

import com.teamway.backend.api.dto.ErrorApiModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@Order(0)
@ControllerAdvice
public class V2ControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorApiModel> handleIncorrectDataException(IncorrectDataException e) {
        log.error(e);
        return new ResponseEntity<>(new ErrorApiModel(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorApiModel> topHandler(Throwable e) {
        log.error(e);
        return new ResponseEntity<>(new ErrorApiModel(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
