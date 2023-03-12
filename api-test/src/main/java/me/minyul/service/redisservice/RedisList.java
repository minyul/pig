package me.minyul.service.redisservice;

import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisList {

    @Qualifier(value = "redisAsyncCommands")
    private final RedisAsyncCommands<String, Object> redisAsyncCommands;

    @Qualifier(value = "redisTemplate")
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisList(RedisAsyncCommands<String, Object> redisAsyncCommands, RedisTemplate<String, Object> redisTemplate) {
        this.redisAsyncCommands = redisAsyncCommands;
        this.redisTemplate = redisTemplate;
    }

    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

}
