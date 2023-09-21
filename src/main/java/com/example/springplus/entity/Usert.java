package com.example.springplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@TableName("usert")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usert {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}