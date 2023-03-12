package me.minyul.service.redisservice;

import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;

import static java.util.Collections.emptySet;

@Service
public class RedisSet {

    @Qualifier(value = "redisAsyncCommands")
    private final RedisAsyncCommands<String, Object> redisAsyncCommands;

    @Qualifier(value = "redisTemplate")
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisSet(RedisAsyncCommands<String, Object> redisAsyncCommands, RedisTemplate<String, Object> redisTemplate) {
        this.redisAsyncCommands = redisAsyncCommands;
        this.redisTemplate = redisTemplate;
    }

    public Long add(String key, Object ...values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    public Long remove(String key, Object ...values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    public Object pop(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    public Boolean move(String key, String value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    public Long size(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    public Set<Object> intersect(String key, String otherKey) {
        return redisTemplate.opsForSet().intersect(key, otherKey);
    }

    public Set<Object> members(String key) {
        return (StringUtils.hasText(key)) ?
            redisTemplate.opsForSet().members(key)
                : emptySet();
    }
}
