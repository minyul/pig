package me.minyul.service.redisservice;

import io.lettuce.core.api.async.RedisAsyncCommands;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisString {

    @Qualifier(value = "redisAsyncCommands")
    private final RedisAsyncCommands<String, Object> redisAsyncCommands;

    @Qualifier(value = "redisTemplate")
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisString(RedisAsyncCommands<String, Object> redisAsyncCommands, RedisTemplate<String, Object> redisTemplate) {
        this.redisAsyncCommands = redisAsyncCommands;
        this.redisTemplate = redisTemplate;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void asyncSet(String key, Object value) {
        redisAsyncCommands.set(key, value);
    }

    public void set(String key, Object value, Long timeout) {
        redisTemplate.opsForValue()
                .set(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    public void set(String key, Object value, Duration timeout) {
        redisTemplate.opsForValue()
            .set(key, value, timeout);
    }

    public void increment(String key) {
        redisTemplate.opsForValue()
                .increment(key);
    }

    public List<Object> multiGet(List<String> keys) {
        return redisTemplate.opsForValue()
                .multiGet(keys);
    }
}
