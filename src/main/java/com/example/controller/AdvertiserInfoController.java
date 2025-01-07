package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdvertiserInfo;
import com.example.service.AdvertiserInfoService;
import com.example.vo.AdvertiserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/advertiserInfo")
public class AdvertiserInfoController {
    @Resource
    private AdvertiserInfoService advertiserInfoService;
    //查询全部
    @GetMapping
    public Result<List<AdvertiserInfoVo>> all(){return Result.success(advertiserInfoService.findAll());}

    //分页查询
    @GetMapping("/page/{name}")
    public Result<PageInfo<AdvertiserInfoVo>> page(@PathVariable String name,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                             HttpServletRequest request) {
        return Result.success(advertiserInfoService.findPage(name, pageNum, pageSize, request));
    }
    //添加
    @PostMapping
    public Result<AdvertiserInfo> add(@RequestBody AdvertiserInfoVo advertiserInfo) {
        advertiserInfoService.add(advertiserInfo);
        return Result.success(advertiserInfo);
    }
    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        advertiserInfoService.delete(id);
        return Result.success();
    }
    //修改内容
    @PutMapping
    public Result update(@RequestBody AdvertiserInfoVo advertiserInfo) {
        advertiserInfoService.update(advertiserInfo);
        return Result.success();
    }
    //检查
    @GetMapping("/{id}")
    public Result<AdvertiserInfo> detail(@PathVariable Long id) {
        AdvertiserInfo advertiserInfo = advertiserInfoService.findById(id);
        return Result.success(advertiserInfo);
    }
    //模糊查询
    @GetMapping("/find")
    public Result<List<AdvertiserInfo>> find(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                       HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdvertiserInfo> list = (List<AdvertiserInfo>) advertiserInfoService.findByNewsName(name);
        return Result.success(list);
    }

}
