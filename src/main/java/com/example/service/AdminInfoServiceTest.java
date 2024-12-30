package com.example.service;

import com.example.vo.AdminVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminInfoServiceTest {
    //管理员信息测试
    List<AdminVo> selectAll();
    PageInfo<AdminVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request);
    List<AdminVo> findAllPage(HttpServletRequest request, String name);
}
