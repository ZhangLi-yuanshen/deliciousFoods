package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.entity.UserInfo;
import com.example.service.AdminInfoService;
import com.example.service.UserInfoService;
import com.example.vo.AdminInfoVo;
import com.example.vo.UserInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    //添加用户
    @PostMapping
    public Result<UserInfo> add(@RequestBody UserInfoVo userInfo) {
        userInfoService.add(userInfo);
        return Result.success(userInfo);
    }
   //删除用户
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userInfoService.delete(id);
        return Result.success();
    }
    //修改用户
    @PutMapping
    public Result update(@RequestBody UserInfoVo userInfo) {
        userInfoService.update(userInfo);
        return Result.success();
    }
    //id查询用户
    @GetMapping("/{id}")
    public Result<UserInfo> detail(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.findById(id);
        return Result.success(userInfo);
    }
    //查询用户
    @GetMapping
    public Result<List<UserInfoVo>> all() {
        return Result.success(userInfoService.findAll());
    }
    //分页查询用户
    @GetMapping("/page/{name}")
    public Result<PageInfo<UserInfoVo>> page(@PathVariable String name,
                                              @RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "5") Integer pageSize,
                                              HttpServletRequest request) {
        return Result.success(userInfoService.findPage(name, pageNum, pageSize, request));
    }
}
