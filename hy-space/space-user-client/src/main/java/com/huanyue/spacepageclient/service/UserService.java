package com.huanyue.spacepageclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huanyue.spacepageclient.dao.UserDao;
import com.huanyue.spacepageclient.dao.orcl.TestUserDao;
import com.huanyue.spacepageclient.entity.Result;
import com.huanyue.spacepageclient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public List<Map<String,Object>> getTestUser(String tableName){
        String sql = "SELECT * FROM " + tableName ;
        return jdbcTemplate.queryForList(sql);

    }



}
