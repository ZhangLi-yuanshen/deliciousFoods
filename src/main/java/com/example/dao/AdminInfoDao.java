package com.example.dao;

import com.example.vo.AdminVo;
import com.example.vo.NewsInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminInfoDao extends Mapper<AdminVo> {
    //查询功能
//    @Select("select * from admin_info")
   List<AdminVo> findByName(@Param("name") String name);
    /**
     * 删除功能
     */

    int delete(@Param("id") Integer id);
    /**
     * 修改功能
     */

    int update(AdminVo adminVo);
    /**
     * 添加功能
     */

    int add(AdminVo adminVo);
}
