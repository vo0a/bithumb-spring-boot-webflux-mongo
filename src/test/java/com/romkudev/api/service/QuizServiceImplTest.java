package com.romkudev.api.service;

import com.romkudev.api.quiz.domain.Quiz;
import com.romkudev.api.quiz.service.GeneratorServiceImpl;
import com.romkudev.api.quiz.service.QuizServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {

    private QuizServiceImpl quizService;
    @Mock
    GeneratorServiceImpl generatorService; // 데이터를 제공하는 객체를 Mock으로 만들기

    @BeforeEach
    void setUp() {
        quizService = new QuizServiceImpl(generatorService);
    }

    @DisplayName("50 * 30 = 1500")
    @Test
    void createQuiz() {
        given(generatorService.randomFactor()).willReturn(50, 30);
        Mono<Quiz> quiz = quizService.createQuiz();
        assertThat(quiz.block().getFactorA(), is(50));
        assertThat(quiz.block().getFactorB(), is(30));
        assertThat(quiz.block().getResult(), is(1500));
    }
}