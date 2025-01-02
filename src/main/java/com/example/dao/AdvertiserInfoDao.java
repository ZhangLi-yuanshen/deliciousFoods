package com.example.dao;

import com.example.pojo.AdvertiserInfo;
import com.example.vo.AdvertiserInfoVo;
import com.example.vo.NewsInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdvertiserInfoDao extends Mapper<AdvertiserInfo> {
    //获取所有公告
    List<AdvertiserInfoVo> findAll(@Param("name") String name);

}
