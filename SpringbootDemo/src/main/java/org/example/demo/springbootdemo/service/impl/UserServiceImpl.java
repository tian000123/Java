package org.example.demo.springbootdemo.service.impl;

import org.example.demo.springbootdemo.common.PageResult;
import org.example.demo.springbootdemo.repository.UserRepository;
import org.example.demo.springbootdemo.service.UserService;
import org.example.demo.springbootdemo.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public PageResult<User> getUsersByPage(Integer pageNum, Integer pageSize) {
        // 参数校验和默认值
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        // 限制最大页大小，防止查询过多数据
        if (pageSize > 100) {
            pageSize = 100;
        }

        // 查询总数
        long total = userRepository.count();

        // 查询当前页数据
        List<User> list = userRepository.findByPage(pageNum, pageSize);

        // 封装分页结果
        return PageResult.of(pageNum, pageSize, total, list);
    }
}
