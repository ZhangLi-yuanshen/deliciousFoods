package com.example.dao;


import com.example.pojo.NewsInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsInfoDao {
    //获取所有饮食咨询
    @Select("SELECT * FROM news_info")
    List<NewsInfo> findAll();
}
