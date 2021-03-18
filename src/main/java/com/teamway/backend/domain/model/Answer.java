package com.teamway.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "answer")
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends BaseModel {
    
    @Column(length = 255)
    private String value;

    @Column(nullable = false)
    private Long score;

}
