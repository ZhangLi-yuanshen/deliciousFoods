package com.example.service.impl;

import com.example.dao.AdvertiserInfoDao;
import com.example.service.AdvertiserInfoService;
import com.example.vo.AdvertiserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdvertiserInfoServiceImpl implements AdvertiserInfoService {
    //获取所有公告
    @Autowired
    private AdvertiserInfoDao advertiserInfoDao;
    public List<AdvertiserInfoVo> findAll(){
        return advertiserInfoDao.findAll("all");
    }
    //分页查询
    public PageInfo<AdvertiserInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdvertiserInfoVo> all = findAllPage(request, name);
        return PageInfo.of(all);
    }

    public List<AdvertiserInfoVo> findAllPage(HttpServletRequest request, String name) {
        return advertiserInfoDao.findAll(name);
    }



}
