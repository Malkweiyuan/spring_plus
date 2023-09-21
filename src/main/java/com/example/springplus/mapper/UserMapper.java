package com.example.springplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springplus.entity.Usert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<Usert> {
    List<Usert> selectUser(@Param("userId") Long userId);
}


