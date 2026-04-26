package org.example.demo.springbootdemo.controller;


import org.example.demo.springbootdemo.common.PageResult;
import org.example.demo.springbootdemo.common.Result;
import org.example.demo.springbootdemo.service.UserService;
import org.example.demo.springbootdemo.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.demo.springbootdemo.util.FileUploadUtil;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final FileUploadUtil fileUploadUtil;
    
    @Autowired
    public UserController(UserService userService, FileUploadUtil fileUploadUtil){
        this.userService = userService;
        this.fileUploadUtil = fileUploadUtil;
    }

    @GetMapping("/page")
    public Result<PageResult<User>> getUsersByPage(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageResult<User> pageResult = userService.getUsersByPage(pageNum, pageSize);
        return Result.success(pageResult);
    }
}
