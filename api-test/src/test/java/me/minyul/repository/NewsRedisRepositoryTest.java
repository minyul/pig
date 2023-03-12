package me.minyul.repository;

import lombok.extern.slf4j.Slf4j;
import me.minyul.dto.repository.NewsDto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest
class NewsRedisRepositoryTest {

    @Autowired
    private NewsRedisRepository redisRepository;

    @DisplayName("토픽 주제가 Null 이면 Null 이 반환된다.")
    @Test
    void shouldReturnResultNullWhenParameterNull() {
        NewsDto news = redisRepository.getTopicNews(null);
        assertThat(news).isNull();
    }
}