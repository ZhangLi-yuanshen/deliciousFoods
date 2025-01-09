package com.example.service;

import com.example.entity.ClassifyInfo;
import com.example.entity.SubClassifyInfo;
import com.example.vo.SubClassifyInfoVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 菜谱小类信息Service接口
 *
 * @author dong
 *
 */
public interface SubClassifyInfoService
{
    /**
     * 查询菜谱小类信息
     *
     * @param id 菜谱小类信息主键
     * @return 菜谱小类信息
     */
    public SubClassifyInfo selectSubClassifyInfoById(Long id);

    /**
     * 查询菜谱小类信息列表
     *
     * @param subClassifyInfo 菜谱小类信息
     * @return 菜谱小类信息集合
     */
    public PageInfo<SubClassifyInfo> selectSubClassifyInfoList(Integer pageNum, Integer pageSize, SubClassifyInfo subClassifyInfo);

    /**
     * 新增菜谱小类信息
     *
     * @param subClassifyInfo 菜谱小类信息
     * @return 结果
     */
    public int insertSubClassifyInfo(SubClassifyInfo subClassifyInfo);

    /**
     * 修改菜谱小类信息
     *
     * @param subClassifyInfo 菜谱小类信息
     * @return 结果
     */
    public int updateSubClassifyInfo(SubClassifyInfo subClassifyInfo);



    /**
     * 删除菜谱小类信息信息
     *
     * @param id 菜谱小类信息主键
     * @return 结果
     */
    public int deleteSubClassifyInfoById(Long id);
    List<SubClassifyInfoVo> findAll();
}
