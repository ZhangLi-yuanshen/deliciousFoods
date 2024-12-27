package com.example.service;

import com.example.vo.NewsInfoVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface NewsInfoService {
    List<NewsInfoVo> findAll();
    PageInfo<NewsInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request);
    List<NewsInfoVo> findAllPage(HttpServletRequest request, String name);
}
