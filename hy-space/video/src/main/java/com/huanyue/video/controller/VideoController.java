package com.huanyue.video.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huanyue.video.entity.Video;
import com.huanyue.video.service.VideoService;

@RestController
@Api(tags = "video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @PostMapping("list")
    public List<Video> listAll() {
        return videoService.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @PostMapping("getById")
    public Video getById(Integer id) {
        return videoService.getById(id);
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param video 新增的记录
     * @return 返回影响行数
     */
    @PostMapping("insert")
    public int insert(@RequestBody Video video) {
        return videoService.insertIgnoreNull(video);
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param video 修改的记录
     * @return 返回影响行数
     */
    @PostMapping("update")
    public int update(@RequestBody Video video) {
        return videoService.updateIgnoreNull(video);
    }
    
    /**
     * 删除记录
     *
     * @param video 待删除的记录
     * @return 返回影响行数
     */
    @PostMapping("delete")
    public int delete(@RequestBody Video video) {
        return videoService.delete(video);
    }
    
}