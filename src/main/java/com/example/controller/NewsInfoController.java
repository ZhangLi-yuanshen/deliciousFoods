package com.example.controller;



import com.example.common.Result;
import com.example.service.NewsInfoService;
import com.example.vo.NewsInfoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

@RequestMapping("/newsInfo")
public class NewsInfoController {
    @Resource
    private NewsInfoService newsInfoService;
    // 获取所有新闻资讯（分页）
    @GetMapping
    public Result<List<NewsInfoVo>> all(
            @RequestParam(defaultValue = "1") int page,  // 默认分页从第1页开始
            @RequestParam(defaultValue = "10") int size  // 默认每页显示10条
    ) {
        return Result.success(newsInfoService.findAll(page, size));
    }
    //查询所有咨询信息
    @GetMapping
    public Result<List<NewsInfoVo>> all(){return Result.success(newsInfoService.findAll());}

}