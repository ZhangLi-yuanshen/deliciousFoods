package com.example.controller;


import com.example.common.Result;
import com.example.service.AdvertiserInfoService;
import com.example.vo.AdvertiserInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/advertiserInfo")
public class AdvertiserInfoController {
    @Resource
    private AdvertiserInfoService advertiserInfoService;
    //枫叶查询
    @GetMapping
    public Result<List<AdvertiserInfoVo>> all(){return Result.success(advertiserInfoService.findAll());}
    @GetMapping("/page/name")
    public Result<PageInfo<AdvertiserInfoVo>> page(@PathVariable String name,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                             HttpServletRequest request) {
        return Result.success(advertiserInfoService.findPage(name, pageNum, pageSize, request));
    }


}
