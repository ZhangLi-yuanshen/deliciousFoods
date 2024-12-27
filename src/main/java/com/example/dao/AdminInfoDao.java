package com.example.dao;

import com.example.vo.AdminVo;
import com.example.vo.NewsInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminInfoDao extends Mapper<AdminVo> {
    //查询功能
//    @Select("select * from admin_info")
   List<AdminVo> findByName(@Param("name") String name);
}
