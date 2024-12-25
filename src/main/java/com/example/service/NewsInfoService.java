package com.example.service;


import com.example.common.QueryRequest;
import com.example.pojo.NewsInfo;
import com.example.util.PageResult;

public interface NewsInfoService {
    /**
     * 分页查询相关数据
     */
    PageResult<NewsInfo> selectNewsInfoList(QueryRequest queryRequest);
}
