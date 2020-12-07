package com.gm.wj.service;

import com.alibaba.fastjson.JSON;
import com.gm.wj.entity.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JdbcTempService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testIn(){
        String sql = "select * from admin_role_menu where id in (:ids) and rid = :rid";
        Map<String, Object> args  = new HashMap<>();
        args.put("rid", "1");
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        args.put("ids", ids);
        NamedParameterJdbcTemplate givenParamJdbcTemp = new NamedParameterJdbcTemplate(jdbcTemplate);
        List< Map<String, Object>> data = givenParamJdbcTemp.queryForList(sql, args);
        data.forEach(stringObjectMap -> {
            System.out.println(JSON.toJSONString(stringObjectMap));
        });

    }

    public void insertData(){

        List<VideoBean> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            VideoBean videoBean = new VideoBean();
            videoBean.setMenuId(1);
            videoBean.setClassId(1);
            videoBean.setClassTitle("未删减版");
            videoBean.setVideoTitle(i + 2 + ".视频标题");
            videoBean.setText("测试视频");
            videoBean.setTitle("空之境界");
            list.add(videoBean);
        }
        for (int i = 0; i < 10; i++) {
            VideoBean videoBean = new VideoBean();
            videoBean.setMenuId(1);
            videoBean.setClassId(2);
            videoBean.setClassTitle("删减版");
            videoBean.setVideoTitle(i  + ".视频标题");
            videoBean.setText("测试视频");
            videoBean.setTitle("空之境界");
            list.add(videoBean);
        }
        for (int i = 0; i < 20; i++) {
            VideoBean videoBean = new VideoBean();
            videoBean.setMenuId(2);
            videoBean.setClassId(1);
            videoBean.setClassTitle("魔法使之夜");
            videoBean.setVideoTitle(i  + ".视频标题");
            videoBean.setText("测试视频");
            videoBean.setTitle("魔法使之夜");
            list.add(videoBean);
        }
        String sql = "insert into video(title,classId,classTitle,path,text,videoTitle,menuId) values(?,?,?,?,?,?,?)";
       jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
           @Override
           public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1,list.get(i).getTitle());
               ps.setInt(2,list.get(i).getClassId());
               ps.setString(3,list.get(i).getClassTitle());
               ps.setString(4,list.get(i).getPath());
               ps.setString(5,list.get(i).getText());
               ps.setString(6,list.get(i).getVideoTitle());
               ps.setInt(7,list.get(i).getMenuId());
           }

           @Override
           public int getBatchSize() {
               return list.size();
           }
       });

    }
}
