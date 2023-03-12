package me.minyul.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.minyul.common.NewsRedisKey;
import me.minyul.dto.repository.NewsDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class NewsRedisRepository {

    private final ObjectMapper objectMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 주제에 맞는 뉴스를 레디스에서 추출한다.
     *
     * @param topic 주제
     * @return topic News
     * @date 2023-03-12
     * @author minyul
     */
    public NewsDto getTopicNews(final String topic) {
        try {
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            return objectMapper.convertValue(
                    valueOperations.get(NewsRedisKey.getNewsKey(topic)),
                    NewsDto.class);
        } catch (Exception e) {
            log.error("[get topic news fail]" + e);
            return new NewsDto();
        }
    }
}
