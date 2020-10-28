package com.gm.wj.controller;

import com.gm.wj.result.Result;
import com.gm.wj.result.ResultCode;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "图书管理")
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private UserService userService;

    @PostMapping("/getWeather/{province}/{city}")
    @ApiOperation(value = "获取天气")
    public Result getWeather(@PathVariable("province") String province, @PathVariable("city") String city){
        try {
            return ResultFactory.buildResult(ResultCode.SUCCESS,"OK",userService.weather(province,city));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildResult(ResultCode.FAIL,e.getMessage(),"");
        }
    }
}
