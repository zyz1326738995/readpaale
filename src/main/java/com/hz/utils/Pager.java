package com.hz.utils;

import java.util.List;

public class Pager<T> {

    // 当前页
    private Integer curr;
    // 每页条数
    private Integer limit;
    // 总记录数
    private Integer total;
    // 分页数据
    List<T> data;

    public Integer getCurr() {
        return curr;
    }

    public void setCurr(Integer curr) {
        this.curr = curr;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
