package com.example.controller;

import com.example.common.Result;
import com.example.entity.CollectInfo;
import com.example.service.CollectInfoService;
import com.example.vo.CollectInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/collectInfo")
public class CollectInfoController {
    @Resource
    private CollectInfoService collectInfoService;

    @PostMapping
    public Result<CollectInfo> add(@RequestBody CollectInfoVo collectInfo, HttpServletRequest request) {
        collectInfoService.add(collectInfo, request);
        return Result.success(collectInfo);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        collectInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody CollectInfoVo collectInfo) {
        collectInfoService.update(collectInfo);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<CollectInfo> detail(@PathVariable Long id) {
        CollectInfo collectInfo = collectInfoService.findById(id);
        return Result.success(collectInfo);
    }

    @GetMapping
    public Result<List<CollectInfoVo>> all() {
        return Result.success(collectInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<CollectInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(collectInfoService.findPage(name, pageNum, pageSize, request));
    }

}
