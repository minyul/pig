package me.minyul.service;

import lombok.extern.slf4j.Slf4j;
import me.minyul.dto.repository.NewsDto;
import me.minyul.repository.NewsRedisRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class NewsServiceTest {

    @Mock
    private NewsRedisRepository newsRedisRepository;

    @InjectMocks
    private NewsService newsService;

    @DisplayName("topic 에 맞는 뉴스를 가져온다.")
    @Test
    void shouldReturnTopicNews() {
        when(newsRedisRepository.getTopicNews("test")).thenReturn(NewsDto.builder()
                .topic("test")
                .title("title")
                .build());

        String title = newsService.findNewsTitleByTopic("test");
        assertThat(title).isEqualTo("title");
    }
}