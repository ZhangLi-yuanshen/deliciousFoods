package com.example.mapper;

import com.example.pojo.NewsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsInfoMapper {
    /**
     * 统计总记录数
     */
    Long selectTotal(@Param("classNo") String classNo,
                     @Param("name") String name);
    /**
     * 分页查询相关数据
     */
    List<NewsInfo> selectNewsList(@Param("offset") Integer offset,
                                     @Param("pageSize") Integer pageSize);
}
