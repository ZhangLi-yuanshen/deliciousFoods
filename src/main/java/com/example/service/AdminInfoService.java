package com.example.service;

import com.example.dao.AdminInfoDao;
import com.example.vo.AdminVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminInfoService {
    @Resource
    private AdminInfoDao adminInfoDao;
    public List<AdminVo> selectAll() {
       return adminInfoDao.findByName("all");
    }
}
