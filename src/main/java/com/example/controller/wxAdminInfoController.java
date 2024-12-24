package com.example.controller;

import com.example.service.AdminInfoService;
import com.example.vo.AdminVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class wxAdminInfoController {
    @Resource
    private AdminInfoService adminInfoService;
    //获取管理员信息
    @GetMapping
    public List<AdminVo> getAdminInfo(){
        return adminInfoService.selectAll();
    }


}