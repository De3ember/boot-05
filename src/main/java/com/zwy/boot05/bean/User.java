package com.zwy.boot05.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;
//以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
