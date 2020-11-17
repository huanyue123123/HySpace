package com.gm.wj.service;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;
import com.gm.wj.dao.UserMapper;
import com.gm.wj.entity.User;
import com.gm.wj.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void login(User user) throws CustomException{
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            throw new CustomException("用户名或密码为空！！！");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e);
            throw new CustomException("用户名不存在！");
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e);
            throw new CustomException("账号或密码错误！");
        } catch (AuthorizationException e) {
            log.error("没有权限！", e);
            throw new CustomException("没有权限！");
        }
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
