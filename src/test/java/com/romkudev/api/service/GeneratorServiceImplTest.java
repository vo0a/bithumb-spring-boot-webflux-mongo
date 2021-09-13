package com.romkudev.api.service;

import com.romkudev.api.quiz.service.GeneratorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class GeneratorServiceImplTest {

    @Mock
    GeneratorServiceImpl generatorService;

    @BeforeEach
    void setUp() {
        generatorService = new GeneratorServiceImpl();
    }

    @DisplayName("랜덤 값 발생 알고리즘 테스트")
    @Test
    void randomFactor() {
        List<Integer> randoms = IntStream.range(0, 1000)
                .map(i -> generatorService.randomFactor())
                .boxed()
                .collect(Collectors.toList());

        // 값이 있는지 없는지 확인 -> assertj 사용
        assertThat(randoms).containsOnlyElementsOf(IntStream.range(11, 100)
                .boxed()
                .collect(Collectors.toList()));
    }
}