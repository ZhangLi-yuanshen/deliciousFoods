package com.example.dao;

import com.example.entity.ClassifyInfo;
import com.example.vo.AdminInfoVo;
import com.example.vo.ClassifyInfoVo;
import com.example.vo.SubClassifyInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜谱大类信息Mapper接口
 *
 * @author dong
 *
 */
@Repository
public interface ClassifyInfoDao
{
    /**
     * 查询菜谱大类信息
     *
     * @param id 菜谱大类信息主键
     * @return 菜谱大类信息
     */
    public ClassifyInfo selectClassifyInfoById(Long id);

    /**
     * 查询菜谱大类信息列表
     *
     * @param classifyInfo 菜谱大类信息
     * @return 菜谱大类信息集合
     */
    public List<ClassifyInfo> selectClassifyInfoList(ClassifyInfo classifyInfo);

    /**
     * 新增菜谱大类信息
     *
     * @param classifyInfo 菜谱大类信息
     */
    public int insertClassifyInfo(ClassifyInfo classifyInfo);

    /**
     * 修改菜谱大类信息
     * @param classifyInfo 菜谱大类信息
     */
    public int updateClassifyInfo(ClassifyInfo classifyInfo);

    /**
     * 删除菜谱大类信息
     *
     * @param id 菜谱大类信息主键
     */
    public int deleteClassifyInfoById(Long id);
    Integer count();
    List<ClassifyInfoVo> findAll();

}
