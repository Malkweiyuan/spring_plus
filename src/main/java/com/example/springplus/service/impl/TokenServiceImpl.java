package com.example.springplus.service.impl;

import com.example.springplus.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author wei
 * @Date 2023/9/2 20:09
 * @Version 1.0
 */
@Service

public class TokenServiceImpl implements TokenService {
    private static final long TOKEN_EXPIRATION_MINUTES = 30;// Token的过期时间（分钟）
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public void storeToken(String userId, String token) {
        String key = "user_token:" + userId;
        redisTemplate.opsForValue().set(key, token, TOKEN_EXPIRATION_MINUTES, TimeUnit.MINUTES);
    }

    @Override
    public String getToken(String userId) {
        String key = "user_token:" + userId;
        return redisTemplate.opsForValue().get(key);
    }
    @Override
    public void deleteToken(String userId) {
        String key = "user_token:" + userId;
        redisTemplate.delete(key);
    }
}
