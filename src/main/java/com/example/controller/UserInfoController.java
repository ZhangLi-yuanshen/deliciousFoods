package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;

import com.example.entity.UserInfo;

import com.example.service.UserInfoService;

import com.example.vo.UserInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    //检查
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
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("name", "//导出用户");
        row.put("password", "123456");
        row.put("nickName", "//导出用户");
        row.put("sex", "男");
        row.put("age", 22);
        row.put("birthday", "TIME");
        row.put("phone", "18843232356");
        row.put("address", "上海市");
        row.put("code", "111");
        row.put("email", "aa@163.com");
        row.put("cardId", "342425199001116372");
        row.put("level", 1);

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=user.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
}
