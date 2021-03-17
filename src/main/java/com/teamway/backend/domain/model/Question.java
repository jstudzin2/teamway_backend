package com.teamway.backend.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity(name = "question")
public class Question extends BaseModel {

    @Column(length = 255)
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Answer> answers;
}
