package com.example.vo;

public class NewsInfoVo {
    private Long id;
    private String title;
    private String content;
    // 构造函数
    public NewsInfoVo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
