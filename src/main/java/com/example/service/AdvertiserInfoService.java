package com.example.service;

import com.example.vo.AdvertiserInfoVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdvertiserInfoService {
        //分页查询
        List<AdvertiserInfoVo> findAll();
        PageInfo<AdvertiserInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request);
        List<AdvertiserInfoVo> findAllPage(HttpServletRequest request, String name);
}
