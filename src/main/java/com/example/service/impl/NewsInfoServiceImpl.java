package com.example.service.impl;


import com.example.common.QueryRequest;
import com.example.dao.NewsInfoDao;
import com.example.mapper.NewsInfoMapper;
import com.example.pojo.NewsInfo;
import com.example.service.NewsInfoService;
import com.example.util.PageResult;
import com.example.vo.NewsInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
    //获取所有饮食咨询
    @Resource
    private NewsInfoDao NewsInfoDao;
    public List<NewsInfoVo> findAll() {
        return NewsInfoDao.findAll("all");
    }
    @Resource
    private NewsInfoMapper newsinfoMapper;



    @Override
    public PageResult<NewsInfo> selectNewsInfoList(QueryRequest queryRequest, String Name, Integer PageNum, Integer PageSize) {
        // 计算偏移量(起始索引) （查询页码-1）*每页显示记录数。
        int offset = (queryRequest.getPageNum() - 1) * queryRequest.getPageSize();
        //查询总记录数
        Long total = newsinfoMapper.selectTotal(queryRequest.getClassNo(), queryRequest.getName());
        List<NewsInfo> courses = newsinfoMapper.selectNewsList(offset, queryRequest.getPageSize());
        return new PageResult<>(courses,queryRequest.getPageNum(),queryRequest.getPageSize(),total);
    }


}
