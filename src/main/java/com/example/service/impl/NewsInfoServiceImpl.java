package com.example.service.impl;


import com.example.dao.NewsInfoDao;
import com.example.service.NewsInfoService;
import com.example.vo.NewsInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
    //获取所有饮食咨询
    @Autowired
    private NewsInfoDao newsInfoDao;

    public List<NewsInfoVo> findAll() {
        return newsInfoDao.findAll("all");
    }

    public PageInfo<NewsInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<NewsInfoVo> all = findAllPage(request, name);
        return PageInfo.of(all);
    }

    public List<NewsInfoVo> findAllPage(HttpServletRequest request, String name) {
        return newsInfoDao.findAll(name);
    }




}
