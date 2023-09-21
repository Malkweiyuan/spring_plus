package com.example.springplus.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "用户传参")
public class UserDTO  implements Serializable {

    private static final long serialVersionUID = -6432225475738412903L;

    @ApiModelProperty(value = "用户id")
    private Long id;

    private String name;

    private Long age;

    private String email;
}
