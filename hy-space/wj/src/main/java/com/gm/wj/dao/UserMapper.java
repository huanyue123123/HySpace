package com.gm.wj.dao;

import com.gm.wj.entity.Role;
import com.gm.wj.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param(value = "id") Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByEntity(User user);

    User selectUserByUserName(@Param(value = "username") String username);

    Set<Role> selectRoleList(@Param(value = "uid") Integer uid);
}
