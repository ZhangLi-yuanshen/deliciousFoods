package com.example.dao;

import com.example.entity.NewsInfo;
import com.example.vo.NewsInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NewsInfoDao extends Mapper<NewsInfo> {
    //根据名字查询全部
    List<NewsInfoVo> findByName(@Param("name") String name);
    //查重
    int checkRepeat(String column, String value, Long id);
    //查询
    NewsInfoVo findByNewsName(String NewsName);
    Integer count();
    //删除
    Integer deleteById(Long id);
    //编辑
    Integer updateById(NewsInfoVo newsInfo);
}
