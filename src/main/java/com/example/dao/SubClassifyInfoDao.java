package com.example.dao;


import com.example.entity.ClassifyInfo;
import com.example.entity.SubClassifyInfo;
import com.example.vo.SubClassifyInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜谱小类信息Mapper接口
 *
 * @author dong
 *
 */
@Repository
public interface SubClassifyInfoDao
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
    public List<SubClassifyInfo> selectSubClassifyInfoList(SubClassifyInfo subClassifyInfo);

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
     * 删除菜谱小类信息
     *
     * @param id 菜谱小类信息主键
     * @return 结果
     */
    public int deleteSubClassifyInfoById(Long id);
    List<SubClassifyInfoVo> findAll();


}
