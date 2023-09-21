package com.example.springplus.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "SaleSummaryVO")
public class UserVO {
    private static final long serialVersionUID = -2761133105138073894L;
    public Long id;
    public String name;
    public Integer age;
    public String email;
}
