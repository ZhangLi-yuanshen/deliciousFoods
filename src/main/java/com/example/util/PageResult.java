package com.example.util;

import java.util.List;

//分页结果类
public class PageResult<T> {
    private List<T> list;      // 数据列表
    private Integer pageNum;    // 当前页码
    private Integer pageSize;   // 每页数量
    private Long total;         // 总记录数
    private Integer pages;      // 总页数

    public PageResult(List<T> list, Integer pageNum, Integer pageSize, Long total) {
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = (int) Math.ceil((double) total / pageSize);
    }
}
