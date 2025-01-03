package com.example.service.impl;

import com.example.dao.AdminDao;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Integer login(String username, String password) {
        return adminDao.adminLogin(username,password);
    }
}
