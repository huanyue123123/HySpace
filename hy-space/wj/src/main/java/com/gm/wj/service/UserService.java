package com.gm.wj.service;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;
import com.gm.wj.dao.UserMapper;
import com.gm.wj.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        subject.login(usernamePasswordToken);
        return null;
    }

    public List<String> weather(String province,String city) throws Exception {
        WeatherWS factory = new WeatherWS();
        // 根据工厂创建一个WeatherWSSoap对象
        WeatherWSSoap weatherWSSoap = factory.getWeatherWSSoap();

        ArrayOfString cityInfo = weatherWSSoap.getSupportCityString(province);
        List<String> lstCityInfo = cityInfo.getString();
        String CityCode = "";
        // 遍历天气预报信息
        for (String string : lstCityInfo) {
            String[] strings = string.split(",");
            if(strings[0] != null && strings[0].equals(city)){
                CityCode = strings[1];
            }
        }
        if(CityCode == null ||CityCode.equals("")){
            throw new Exception("未找到城市信息");
        }

        ArrayOfString weatherInfo = weatherWSSoap.getWeather(CityCode,"");
        List<String> lstWeatherInfo = weatherInfo.getString();
        return lstWeatherInfo;
    }
}
