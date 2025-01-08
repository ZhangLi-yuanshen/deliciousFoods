package com.example.service;

import com.example.dao.AdvertiserInfoDao;
import com.example.entity.AdvertiserInfo;
import com.example.vo.AdvertiserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdvertiserInfoService {
    @Resource
    private AdvertiserInfoDao advertiserInfoDao;
    //根据名字查询全部
    public List<AdvertiserInfoVo> findAll() {return advertiserInfoDao.findByName("all");}
    //分页查询
    public PageInfo<AdvertiserInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdvertiserInfoVo> all = advertiserInfoDao.findByName(name);
        return PageInfo.of(all);
    }
    //删除
    public void delete(Long id) {
        advertiserInfoDao.deleteById(id);
    }
//    public void delete(Long id) {
//        advertiserInfoDao.deleteByPrimaryKey(id);
//    }
    //编辑
    public void update(AdvertiserInfo advertiserInfo) {
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoDao.updateByPrimaryKeySelective(advertiserInfo);
    }
    //根据name查询
    public AdvertiserInfo findById(Long id) {
        return advertiserInfoDao.selectByPrimaryKey(id);
    }
    public AdvertiserInfoVo findByNewsName(String name) {
        return advertiserInfoDao.findByAdvertiserName(name);
    }
    //增加
    public AdvertiserInfo add(AdvertiserInfo advertiserInfo) {
        //时间
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoDao.insertSelective(advertiserInfo);
        return advertiserInfo;
    }


}
