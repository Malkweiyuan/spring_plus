package com.example.springplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springplus.dto.UserDTO;
import com.example.springplus.entity.Usert;
import com.example.springplus.mapper.UserMapper;
import com.example.springplus.service.ValidationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ValidationServiceImpl implements ValidationService {

    private static final String UNIQUE_ID_KEY = "unique:id"; // Redis中存储唯一ID的键

    @Autowired
    private UserMapper userMapper;

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper; // Jackson ObjectMapper

    public ValidationServiceImpl(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public String addUser(UserDTO user) {

        Usert user1 = new Usert();
        BeanUtils.copyProperties(user, user1);
        user1.setId(getId());
        this.userMapper.insert(user1);
        return user1.getEmail();
    }

    @Override
    public Page<Usert> getUser(UserDTO user) {
        Page<Usert> page = new Page<>(1, 10);
        List<Usert> usertList = new ArrayList<>();
        usertList = this.userMapper.selectUser(user.getId());
        QueryWrapper<Usert> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", user.getName());
        usertList = this.userMapper.selectList(queryWrapper);
//        LambdaQueryWrapper<Usert> lambdaQueryWrapper = new QueryWrapper<Usert>().lambda();
//        lambdaQueryWrapper.like(Usert::getName, user.getName())
//                .or().like(Usert::getAge, user.getAge())
//                .or().like(Usert::getEmail, user.getEmail());
        String sUser = redisTemplate.opsForValue().get("user");
        try {

            if (StringUtils.isEmpty(sUser)) {
                String  jsonString = objectMapper.writeValueAsString(usertList);

                redisTemplate.opsForValue().set("user", jsonString);
                redisTemplate.expire("user", 1, TimeUnit.MINUTES);
            } else {
                String jsonString = redisTemplate.opsForValue().get("user");
                usertList = objectMapper.readValue(jsonString, new TypeReference<List<Usert>>() {
                });
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // Usert u = this.userMapper.selectById(user.getId());
//        Usert u1 = new Usert();
//        u1.setEmail("1");
//        usertList.add(u1);
//        Usert u2 = new Usert();
//        u2.setEmail("2");
//        usertList.add(u2);
        page.setRecords(usertList);
        return page;
    }

    @Override
    public Long getId() {
        Long redisId = redisTemplate.opsForValue().increment(UNIQUE_ID_KEY, 10);
        redisTemplate.expire(UNIQUE_ID_KEY, 1, TimeUnit.MINUTES);
        return redisId;
    }

    public void getRedis() {
        redisTemplate.hasKey("");//检查key是否存在
        redisTemplate.opsForValue().get("");
        redisTemplate.opsForValue().set("key", "value", 60, TimeUnit.DAYS);
        redisTemplate.opsForHash().putAll("map", new HashMap<>());


    }
}
