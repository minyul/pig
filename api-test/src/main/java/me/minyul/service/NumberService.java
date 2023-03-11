package me.minyul.service;

public class NumberService {

    /**
     * 수학 점수와 영어 점수를 입력 받아 합산 결과를 반환한다.
     *
     * @date 2023-03-11
     * @author minyul
     */
    public Integer addMathScoreAndEngScore(final Integer mathScore, final Integer englishScore) {
        return mathScore + englishScore;
    }
}
