package com.example.springplus.service;

/**
 * @Author wei
 * @Date 2023/9/2 20:09
 * @Version 1.0
 */
public interface TokenService {
    public void storeToken(String userId, String token);
    public String getToken(String userId);

    public void deleteToken(String userId);
}
