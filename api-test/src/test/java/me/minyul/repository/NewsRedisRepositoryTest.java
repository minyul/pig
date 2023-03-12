package me.minyul.repository;

import lombok.extern.slf4j.Slf4j;
import me.minyul.common.NewsRedisKey;
import me.minyul.dto.repository.NewsDto;

import me.minyul.service.redisservice.RedisString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest
class NewsRedisRepositoryTest {

    private static final String NEWS_TEST_TOPIC = "test";

    @Autowired
    private NewsRedisRepository redisRepository;

    @Autowired
    private RedisString redisString;

    @BeforeEach
    void init() {
        NewsDto testDto = NewsDto.builder()
                .topic("test")
                .media("media")
                .title("title")
                .updateTime(LocalDateTime.now().atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli())
                .build();
        redisString.set(NewsRedisKey.getNewsKey(NEWS_TEST_TOPIC), testDto);
    }

    @DisplayName("저장한 뉴스 데이터를 반환한다.")
    @Test
    void shouldReturnResultNewsData() {
        NewsDto news = redisRepository.getTopicNews(NEWS_TEST_TOPIC);
        assertThat(news.getTopic()).isEqualTo(NEWS_TEST_TOPIC);
    }

    @DisplayName("토픽 주제가 Null 이면 Null 이 반환된다.")
    @Test
    void shouldReturnResultNullWhenParameterNull() {
        NewsDto news = redisRepository.getTopicNews(null);
        assertThat(news).isNull();
    }

    @AfterEach
    void end() {
        redisString.delete(NewsRedisKey.getNewsKey(NEWS_TEST_TOPIC));
    }
}