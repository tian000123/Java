package org.example.demo.springbootdemo.service;

import org.example.demo.springbootdemo.common.PageResult;
import org.example.demo.springbootdemo.util.User;

public interface UserService {
    PageResult<User> getUsersByPage(Integer pageNum, Integer pageSize);
}
