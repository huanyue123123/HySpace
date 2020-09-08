package com.huanyue.spacepageclient.dao;

import com.huanyue.spacepageclient.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    User selectByName(User user);

    List<User> queryUserList(User user);

}
