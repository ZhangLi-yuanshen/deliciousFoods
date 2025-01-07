package com.example.service.impl;

import java.util.List;

import com.example.dao.SubClassifyInfoDao;
import com.example.entity.SubClassifyInfo;
import com.example.service.SubClassifyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 菜谱小类信息Service业务层处理
 *
 * @author dong
 *
 */
@Service
public class SubClassifyInfoServiceImpl implements SubClassifyInfoService
{
    @Autowired
    private SubClassifyInfoDao subClassifyInfoDao;

    /**
     * 查询菜谱小类信息
     *
     * @param id 菜谱小类信息主键
     * @return 菜谱小类信息
     */
    @Override
    public SubClassifyInfo selectSubClassifyInfoById(Long id)
    {
        return subClassifyInfoDao.selectSubClassifyInfoById(id);
    }

    /**
     * 查询菜谱小类信息列表
     *
     * @param subClassifyInfo 菜谱小类信息
     * @return 菜谱小类信息
     */
    @Override
    public PageInfo<SubClassifyInfo> selectSubClassifyInfoList(Integer pageNum, Integer pageSize, SubClassifyInfo subClassifyInfo)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<SubClassifyInfo> all = subClassifyInfoDao.selectSubClassifyInfoList(subClassifyInfo);
        return PageInfo.of(all);

    }

    /**
     * 新增菜谱小类信息
     *
     * @param subClassifyInfo 菜谱小类信息
     * @return 结果
     */
    @Override
    public int insertSubClassifyInfo(SubClassifyInfo subClassifyInfo)
    {
        return subClassifyInfoDao.insertSubClassifyInfo(subClassifyInfo);
    }

    /**
     * 修改菜谱小类信息
     *
     * @param subClassifyInfo 菜谱小类信息
     * @return 结果
     */
    @Override
    public int updateSubClassifyInfo(SubClassifyInfo subClassifyInfo)
    {
        return subClassifyInfoDao.updateSubClassifyInfo(subClassifyInfo);
    }


    /**
     * 删除菜谱小类信息信息
     *
     * @param id 菜谱小类信息主键
     * @return 结果
     */
    @Override
    public int deleteSubClassifyInfoById(Long id)
    {
        return subClassifyInfoDao.deleteSubClassifyInfoById(id);
    }
}
