package com.huanyue.video.entity;


public class Video extends PageEntity {
	private Integer id;
	private String title;
	/** 小分类 */
	private Integer classId;
	private String classTitle;
	/** 路径 */
	private String path;
	/** 简介 */
	private String text;
	/** 视频标题 */
	private String videoTitle;
	/** 大分类 */
	private Integer menuId;

	public Video() {
		initStartIndex();
	}
    
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	public Integer getClassId() {
		return this.classId;
	}
	
	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}
	
	public String getClassTitle() {
		return this.classTitle;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	
	public String getVideoTitle() {
		return this.videoTitle;
	}
	
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	public Integer getMenuId() {
		return this.menuId;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Video that = (Video) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Video{" +
				"id=" + id +
						",title='" + title + "'" + 
						",classId='" + classId + "'" + 
						",classTitle='" + classTitle + "'" + 
						",path='" + path + "'" + 
						",text='" + text + "'" + 
						",videoTitle='" + videoTitle + "'" + 
						",menuId='" + menuId + "'" + 
		                '}';
    }
	
}