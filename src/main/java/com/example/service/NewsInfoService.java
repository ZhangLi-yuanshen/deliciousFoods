package com.example.service;

import com.example.dao.NewsInfoDao;
import com.example.pojo.NewsInfo;
import com.example.vo.NewsInfoVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsInfoService {
    //获取所有饮食咨询
    @Resource
    private NewsInfoDao NewsInfoDao;
    public List<NewsInfoVo> findAll() {
        return NewsInfoDao.findAll("all");
    }
}
