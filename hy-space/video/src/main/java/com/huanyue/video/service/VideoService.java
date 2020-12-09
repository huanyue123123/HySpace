package com.huanyue.video.service;

import com.huanyue.video.entity.Video;
import com.huanyue.video.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Video> listAll() {
    	return videoMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public Video getById(Integer id) {
    	return videoMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param video 新增的记录
     * @return 返回影响行数
     */
    public int insert(Video video) {
    	return videoMapper.insert(video);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param video 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Video video) {
    	return videoMapper.insertIgnoreNull(video);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param video 修改的记录
     * @return 返回影响行数
     */
    public int update(Video video) {
    	return videoMapper.update(video);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param video 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Video video) {
    	return videoMapper.updateIgnoreNull(video);
    }
	
    /**
     * 删除记录
     *
     * @param video 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Video video) {
    	return videoMapper.delete(video);
    }
	
}