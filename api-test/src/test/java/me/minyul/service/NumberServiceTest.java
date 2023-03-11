package me.minyul.service;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {

    private NumberService numberService;

    @BeforeEach
    void init() {
        numberService = new NumberService();
    }

    @DisplayName("수학점수와 영어점수를 더하면 그 결과값은 더한 값이 나와야한다.")
    @ParameterizedTest
    @MethodSource("provideMathAndEngScore")
    void shouldReturnResultWithMathScoreAndEngScore(Integer mathScore, Integer engScore) {

        Integer result = numberService.addMathScoreAndEngScore(mathScore, engScore);
        assertThat(result).isEqualTo(mathScore + engScore);
    }

    private static Stream<Arguments> provideMathAndEngScore() {
        return Stream.of(
                Arguments.of(10, 12),
                Arguments.of(3, 2),
                Arguments.of(1, 5)
        );
    }
}