package com.example.service.impl;

import com.example.dao.AdminInfoDao;
import com.example.service.AdminInfoServiceTest;
import com.example.vo.AdminVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class AdminInfoServiceImpl implements AdminInfoServiceTest {
    @Autowired
    private AdminInfoDao adminInfoDao;
    @Override
    public List<AdminVo> selectAll() {
        return adminInfoDao.findByName("all");
    }

    @Override
    public PageInfo<AdminVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdminVo> all = findAllPage(request, name);
        return PageInfo.of(all);
    }

    @Override
    public List<AdminVo> findAllPage(HttpServletRequest request, String name) {
        return adminInfoDao.findByName(name);
    }
}