package com.huanyue.spacepageclient.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huanyue.spacepageclient.dao.UserDao;
import com.huanyue.spacepageclient.dao.orcl.TestUserDao;
import com.huanyue.spacepageclient.entity.Result;
import com.huanyue.spacepageclient.entity.User;
import com.huanyue.spacepageclient.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private TestUserDao testUserDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Result login(User user){
        User checkUser = new User();
        checkUser.setUsername(user.getUsername());
        checkUser = userDao.selectByName(checkUser);
        if(checkUser == null){
            return new Result(-1,"不存在此用户");
        }
        User loginUser = userDao.selectByName(user);
        if(loginUser == null){
            return new Result(-2,"密码错误");
        }
        return new Result(1,"登录成功",loginUser);
    }


}
