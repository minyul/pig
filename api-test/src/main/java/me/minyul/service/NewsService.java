package me.minyul.service;

import lombok.RequiredArgsConstructor;
import me.minyul.dto.repository.NewsDto;
import me.minyul.repository.NewsRedisRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NewsService {

    private final NewsRedisRepository newsRedisRepository;

    /**
     * 레디스에 가져온 뉴스 데이터의 제목을 반환한다.
     *
     * @param topic 뉴스에 대한 토픽
     * @return 뉴스 타이틀
     * @author minyul
     * @date 2023-03-12
     */
    public String findNewsTitleByTopic(final String topic) {
        NewsDto news = newsRedisRepository.getTopicNews(topic);
        return news.getTitle();
    }
}
