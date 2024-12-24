package com.example.dao;


import com.example.pojo.NewsInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface NewsInfoDao extends Mapper<NewsInfo> {
    //获取所有饮食咨询
    List<NewsInfo> findAll();

}
