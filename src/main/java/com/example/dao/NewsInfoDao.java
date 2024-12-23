package com.example.dao;


import org.apache.ibatis.annotations.Select;

public interface NewsInfoDao {
    //获取所有饮食咨询
    @Select("SELECT * FROM news_info")
    List<NewsInfo> findAll();
}
