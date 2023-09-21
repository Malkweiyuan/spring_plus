package com.example.springplus.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@ToString
@Component
@NoArgsConstructor//无参构造器
@Accessors(chain = true)
@ApiModel(description = "用户信息")
public class User {
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "用户id")
    private Long id;
    private String name;
    @NotNull(message = "年龄不能为空")
    private Long age;
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

}
