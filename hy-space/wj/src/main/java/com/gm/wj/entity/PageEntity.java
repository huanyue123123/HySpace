package com.gm.wj.entity;

public class PageEntity {

    private Integer pageNo;

    private Integer pageStartIndex;

    private Integer pageSize;

    public PageEntity(){
        this.pageNo = 1;
        this.pageSize = 30;
        this.pageStartIndex = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageStartIndex() {
        return pageStartIndex;
    }

    public void setPageStartIndex(Integer pageStartIndex) {
        this.pageStartIndex = pageStartIndex;
    }

    public void initStartIndex(){
        if(pageNo==null) pageNo=1;
        if(pageSize==null) pageSize=30;
        this.pageStartIndex = (pageNo-1)*this.pageSize;
    }
}
