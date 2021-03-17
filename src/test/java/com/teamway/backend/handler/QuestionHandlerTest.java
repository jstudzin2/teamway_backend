package com.teamway.backend.handler;

import com.teamway.backend.api.dto.ScoreApiModel;
import com.teamway.backend.domain.model.Answer;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import com.teamway.backend.domain.repository.AnswerJpaRepository;
import com.teamway.backend.domain.repository.QuestionJpaRepository;
import java.util.List;

@RunWith(SpringRunner.class)
public class QuestionHandlerTest {

    private QuestionJpaRepository questionJpaRepository = Mockito.mock(QuestionJpaRepository.class);
    private AnswerJpaRepository answerJpaRepository = Mockito.mock(AnswerJpaRepository.class);

    QuestionHandler handler;

    @Before
    public void setUp() throws Exception {
        handler = new QuestionHandler(questionJpaRepository, answerJpaRepository, new ScoreService(), new ApiMapper());
    }

    @Test
    public void checkIfScoreIsCalculatedProperly() {
        //given
        List<Long> answerIds = Lists.list(1L);
        Mockito.when(answerJpaRepository.findAllById(answerIds)).thenReturn(Lists.list(new Answer("answer1", 4L)));
        //when
        ScoreApiModel response = handler.calculateScore(answerIds);

        //then
        Assert.assertEquals(4, response.getMyScore().longValue());
    }
}
