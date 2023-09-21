package com.example.springplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springplus.dto.UserDTO;
import com.example.springplus.entity.Usert;


public interface ValidationService {

    public String addUser(UserDTO user);

    public Page<Usert> getUser(UserDTO user);

    public Long getId();
}
