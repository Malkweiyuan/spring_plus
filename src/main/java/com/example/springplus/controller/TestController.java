package com.example.springplus.controller;

import com.example.springplus.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

public class TestController {

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Validated User user, BindingResult bindingResult) {
        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(!allErrors.isEmpty()){
            return allErrors.stream()
                    .map(o->o.getDefaultMessage())
                    .collect(Collectors.toList()).toString();
        }
        // 返回默认的错误信息
         return allErrors.get(0).getDefaultMessage();
        //return validationService.addUser(user);
    }
}
