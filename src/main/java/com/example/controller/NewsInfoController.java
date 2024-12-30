package com.example.controller;



import com.example.common.Result;
import com.example.pojo.NewsInfo;
import com.example.service.NewsInfoService;
import com.example.vo.NewsInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController

@RequestMapping("/newsInfo")
public class NewsInfoController {
    @Resource
    private NewsInfoService newsInfoService;
    //分页查询
    @GetMapping
    public Result<List<NewsInfoVo>> all(){return Result.success(newsInfoService.findAll());}
    @GetMapping("/page/{name}")
    public Result<PageInfo<NewsInfoVo>> page(@PathVariable String name,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                             HttpServletRequest request) {
        return Result.success(newsInfoService.findPage(name, pageNum, pageSize, request));
    }
    //增加咨询
    @GetMapping
    public Result<Integer> insert(NewsInfo newsInfo){
        return Result.success(newsInfoService.insert(newsInfo));
    }
}