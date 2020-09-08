package com.huanyue.spacepageclient.controller;

import com.huanyue.spacepageclient.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/table")
@CrossOrigin
public class TableController {

    @PostMapping
    @RequestMapping("/list")
    public Map<String,Object> initTableData(User user){
        Map<String,Object> map = new HashMap<>();
        map.put("code","1");
        map.put("msg","123");
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("total",10);
        List<User> users = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            User u = new User();
            u.setId(i);
            u.setUsername("Hello"+i);
            u.setPassword("pwd"+i);
            users.add(u);
        }
        dataMap.put("rows",users);

        map.put("data",dataMap);


        return dataMap;
    }

}
