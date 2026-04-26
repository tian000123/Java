package org.example.demo.springbootdemo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer age;
    private Integer gender;
    private LocalDate birthday;
    private String bio;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
