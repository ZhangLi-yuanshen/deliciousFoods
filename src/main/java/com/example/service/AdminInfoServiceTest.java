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
    /**
     * 删除功能
     */
    int delete(Integer id);
    /**
     * 根据ID修改管理员功能
     */
    int update(AdminVo adminvo);
    /**
     * 添加管理员功能
     */
    int add(AdminVo adminvo);
}
