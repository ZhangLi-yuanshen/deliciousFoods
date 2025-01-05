package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    //管理员登录
     int adminLogin(String username,String password);
}
