package com.example.dao;

import com.example.entity.AdvertiserInfo;
import com.example.vo.AdvertiserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdvertiserInfoDao extends Mapper<AdvertiserInfo> {

    //根据名字查询全部
    List<AdvertiserInfoVo> findByName(@Param("name") String name);
    //查重
    int checkRepeat(String column, String value, Long id);
    //查询
    AdvertiserInfoVo findByAdvertiserName(String AdvertiserName);
    Integer count();
    //删除
    int deleteById(Long id);
}
