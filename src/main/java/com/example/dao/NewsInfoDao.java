package com.example.dao;


import com.example.pojo.NewsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsInfoDao extends Mapper<NewsInfo> {
    //获取所有饮食咨询
    @Select("SELECT * FROM news_info")
    List<NewsInfo> findAll();
}
