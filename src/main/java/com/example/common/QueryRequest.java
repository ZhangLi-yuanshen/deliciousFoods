package com.example.common;

import lombok.Data;

@Data
public class QueryRequest {
    private Integer pageNum = 1; // 当前页
    private Integer pageSize = 10; // 一页显示10条
    private String classNo;
    private String name;
}
