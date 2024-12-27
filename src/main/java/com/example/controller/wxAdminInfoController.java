package com.example.controller;

import com.example.common.Result;
import com.example.service.AdminInfoServiceTest;
import com.example.vo.AdminVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class wxAdminInfoController {
    @Resource
    private AdminInfoServiceTest adminInfoService;
    //获取管理员信息
    @GetMapping
    public List<AdminVo> getAdminInfo(){
        return adminInfoService.selectAll();
    }
    //分页查询
    @GetMapping("/page/{name}")
    public Result<PageInfo<AdminVo>> page(@PathVariable String name,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                             HttpServletRequest request) {
        return Result.success(adminInfoService.findPage(name, pageNum, pageSize, request));
    }

}