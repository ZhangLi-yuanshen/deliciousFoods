package com.example.service;

import com.example.pojo.NewsInfo;
import com.example.vo.NewsInfoVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface NewsInfoService {
    //分页查询
    List<NewsInfoVo> findAll();
    PageInfo<NewsInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request);
    List<NewsInfoVo> findAllPage(HttpServletRequest request, String name);
    //新增饮食咨询
    int insert(NewsInfo newsInfo);
    //删除饮食咨询信息
    int delete(Integer id);
}
