package me.minyul.service.redisservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisBase {

    @Qualifier(value = "redisTemplate")
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisBase(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    public byte[] dump(String key) {
        return redisTemplate.dump(key);
    }

    public Boolean hashKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public Boolean expire(String key, Long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    public Boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }

    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    public Boolean move(String key, Integer dbIndex) {
        return redisTemplate.move(key, dbIndex);
    }

    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }

    public Long getExpire(String key, TimeUnit unit) {
        return redisTemplate.getExpire(key, unit);
    }

    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    public String randomKey() {
        return redisTemplate.randomKey();
    }

    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    public Boolean renameIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    public DataType type(String key) {
        return redisTemplate.type(key);
    }

    public Cursor<byte[]> scan(String pattern, Long count) {
        return Objects.requireNonNull(
                redisTemplate.getConnectionFactory())
        .getConnection()
        .scan(ScanOptions.scanOptions().match(pattern).count(count)
                .build());
    }

}
