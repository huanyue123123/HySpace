package com.huanyue.spacepageclient.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huanyue.spacepageclient.entity.Result;
import com.huanyue.spacepageclient.entity.User;
import com.huanyue.spacepageclient.service.UserService;
import com.huanyue.spacepageclient.util.CsvUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("${apiPath}/user")
@Api(tags = {"用户"})
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }





}
