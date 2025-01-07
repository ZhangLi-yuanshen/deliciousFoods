package com.example.service;



import com.example.dao.NewsInfoDao;
import com.example.entity.NewsInfo;
import com.example.vo.NewsInfoVo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class NewsInfoService {
    @Resource
    private NewsInfoDao newsInfoDao;
    //查询所有信息
    public List<NewsInfoVo> findAll() {return newsInfoDao.findByName("all");}
    //分页查询
    public PageInfo<NewsInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<NewsInfoVo> all = newsInfoDao.findByName(name);
        return PageInfo.of(all);
    }
//删除
    public void delete(Long id) {
        newsInfoDao.deleteByPrimaryKey(id);
    }
//编辑
    public void update(NewsInfo newsInfo) {
        newsInfoDao.updateByPrimaryKeySelective(newsInfo);
    }
//根据name查询
    public NewsInfo findById(Long id) {
        return newsInfoDao.selectByPrimaryKey(id);
    }
    public NewsInfoVo findByNewsName(String name) {
        return newsInfoDao.findByNewsName(name);
    }
    //增加
    public NewsInfo add(NewsInfo newsInfo) {
        newsInfoDao.insertSelective(newsInfo);
        return newsInfo;
    }


}
