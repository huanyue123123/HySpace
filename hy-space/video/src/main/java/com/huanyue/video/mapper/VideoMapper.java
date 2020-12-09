package com.huanyue.video.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.huanyue.video.entity.Video;

@Mapper
public interface VideoMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Video> listAll();


	/**
	 * 查询所有记录-分页查询
	 *
	 * @return 返回集合，没有返回空List
	 */
    List<Video> listPage();

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	Video getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param video 新增的记录
     * @return 返回影响行数
     */
	int insert(Video video);
	
	/**
     * 新增，忽略null字段
     *
     * @param video 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Video video);
	
	/**
     * 修改，修改所有字段
     *
     * @param video 修改的记录
     * @return 返回影响行数
     */
	int update(Video video);
	
	/**
     * 修改，忽略null字段
     *
     * @param video 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Video video);
	
	/**
     * 删除记录
     *
     * @param video 待删除的记录
     * @return 返回影响行数
     */
	int delete(Video video);
	
}