package com.example.controller;



import com.example.common.Result;
import com.example.pojo.NewsInfo;
import com.example.service.NewsInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/NewsInfo")
public class NewsInfoController {
    @Resource
    private NewsInfoService newsInfoService;
    @GetMapping
    public Result<List<NewsInfo>> all(){return Result.success(newsInfoService.findAll());}
}