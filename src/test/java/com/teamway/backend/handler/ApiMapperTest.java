package com.teamway.backend.handler;

import com.teamway.backend.api.dto.QuestionApiModel;
import com.teamway.backend.domain.model.Answer;
import com.teamway.backend.domain.model.Question;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ApiMapperTest {

    ApiMapper apiMapper = new ApiMapper();

    @Test
    public void checkMappingIsCorrect() {
        //given
        Question question = new Question();
        question.setDescription("desc");
        question.setAnswers(Lists.list(new Answer("introvertic", 5L)));
        //when
        List<QuestionApiModel> response = apiMapper.map(Lists.list(question));

        //then
        Assert.assertEquals(question.getDescription(), response.get(0).getDescription());
    }
}
