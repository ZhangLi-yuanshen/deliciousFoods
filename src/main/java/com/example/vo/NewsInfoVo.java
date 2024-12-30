package com.example.vo;

public class NewsInfoVo {
    private Long id;
    private String name;
    private String content;
    // 构造函数
    public NewsInfoVo(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
}
