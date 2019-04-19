package com.polycis.api.nb.common.vo;

import java.io.Serializable;

public class PageInfoVO implements Serializable {
    /**
     * 查询页
     */
    private Integer pageNum;
    /**
     * 每页显示条数
     */
    private Integer pageSize;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "PageInfoVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
