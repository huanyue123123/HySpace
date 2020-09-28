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

    public List<Map<String,Object>> getTestUser(String tableName){
        String sql = "SELECT * FROM " + tableName ;
        return jdbcTemplate.queryForList(sql);

    }

    @Transactional
    public void readExcelInsertData(String path){
        String sql = "delete from ZCFH_JYXM";
        jdbcTemplate.execute(sql);
        Map<String,List<Map<String,String>>> map = ExcelUtil.readExcel(path);
        String[] titleList = "zcbm,zcSort,jyxm,xzyq,dw,bz,jyxm_cs,pdyj,sydm".split(",");
        for(String key:map.keySet()){
            List<Map<String,String>> mapList = map.get(key);
            jdbcTemplate.batchUpdate("insert into ZCFH_JYXM values(?,?,?,?,?,?,?,?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String,String> jObj = mapList.get(i);
                    String zcbm = jObj.get(titleList[0]);
                    String sort = jObj.get(titleList[1]);
                    String jyxm = jObj.get(titleList[2]);
                    String xzyq = jObj.get(titleList[3]);
                    String dw = jObj.get(titleList[4]);
                    String bz = jObj.get(titleList[5]);
                    String jyxm_cs = jObj.get(titleList[6]);
                    String pdyj = jObj.get(titleList[7]);
                    String csvLbdm = jObj.get(titleList[8]);
                    ps.setString(1,zcbm);
                    ps.setString(2,sort);
                    ps.setString(3,jyxm);
                    ps.setString(4,xzyq);
                    ps.setString(5,dw);
                    ps.setString(6,bz);
                    ps.setString(7,jyxm_cs);
                    ps.setString(8,pdyj);
                    ps.setString(9,csvLbdm);
                }

                @Override
                public int getBatchSize() {
                    return map.get(key).size();
                }
            });
        }


    }

    public List<String> queryZcbm(String lbdm){
        String sql = "SELECT \"zcbm\" FROM ZCFH_JYXM WHERE \"sydm\" like '%" + lbdm + "%'";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps.stream().map(mp->{
            return mp.get("zcbm")==null?"":mp.get("zcbm").toString();
        }).collect(Collectors.toList());
    }

    public List<String> queryZcbmValidate(String lbdm){
        String sql = "SELECT \"zcbm\" FROM ZCFH_VALIDATE WHERE \"lbdm\" like '%" + lbdm + "%'";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps.stream().map(mp->{
            return mp.get("zcbm")==null?"":mp.get("zcbm").toString();
        }).collect(Collectors.toList());
    }

    @Transactional
    public void delValidate(){
        String del = "delete from ZCFH_VALIDATE";
        jdbcTemplate.execute(del);
    }

    @Transactional
    public void insertData(String json,String fileName){

        JSONArray jsArr = JSON.parseArray(json);
        for(Object obj:jsArr){
            JSONObject jobj = (JSONObject)obj;
            jobj.put("lbdm",fileName);
            ((JSONObject) obj).remove("");
        }
        JSONObject jobj = (JSONObject)jsArr.get(0);
        StringBuffer sql = new StringBuffer("insert into ZCFH_VALIDATE(");
        int i = 0;
        List<String> keyList = new ArrayList<>(jobj.keySet());
        for(String key:keyList){
            if(i==jobj.keySet().size()-1){
                sql.append("\""+key + "\")");
            }else{
                sql.append("\""+key+"\",");
            }
            i++;
        }
        sql.append(" VALUES(");
        i=0;
        for(String key:keyList){
            String value = jobj.get(key) == null?"":jobj.get(key).toString();
            if(i==jobj.keySet().size()-1){
                sql.append("?)");
            }else{
                sql.append("?,");
            }
            i++;
        }


        //ZCFH_VALIDATE
        jdbcTemplate.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int j) throws SQLException {
                for(int k = 0;k < keyList.size();k++){
                    JSONObject jobj = (JSONObject)jsArr.get(j);
                    String value = jobj.getString(keyList.get(k));
                    if("zcbm".equals(keyList.get(k))){
                        System.out.println(value);
                        System.out.println(fileName);
                        System.out.println(j);
                    }
                    ps.setString(k+1,value);
                }

            }

            @Override
            public int getBatchSize() {
                return jsArr.size();
            }
        });
    }

}
