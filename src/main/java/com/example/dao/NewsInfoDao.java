package com.example.dao;


import com.example.pojo.NewsInfo;
import com.example.vo.NewsInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface NewsInfoDao extends Mapper<NewsInfo> {
    //获取所有饮食咨询
    List<NewsInfoVo> findAll(@Param("name") String name);
    //新增饮食咨询
    int insert(NewsInfo newsInfo);
    


}
