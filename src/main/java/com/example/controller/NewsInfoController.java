package com.example.controller;

import com.example.common.Result;
import com.example.entity.NewsInfo;
import com.example.service.NewsInfoService;
import com.example.vo.NewsInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/newsInfo")
public class NewsInfoController {
    @Resource
    private NewsInfoService newsInfoService;
    //查询全部
    @GetMapping
    public Result<List<NewsInfoVo>> all(){return Result.success(newsInfoService.findAll());}

    //分页查询
    @GetMapping("/page/{name}")
    public Result<PageInfo<NewsInfoVo>> page(@PathVariable String name,
                                              @RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "5") Integer pageSize,
                                              HttpServletRequest request) {
        return Result.success(newsInfoService.findPage(name, pageNum, pageSize, request));
    }
    //添加
    @PostMapping
    public Result<NewsInfo> add(@RequestBody NewsInfoVo newsInfo) {
        newsInfoService.add(newsInfo);
        return Result.success(newsInfo);
    }
    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        newsInfoService.delete(id);
        return Result.success();
    }
    //修改内容
    @PutMapping
    public Result update(@RequestBody NewsInfoVo newsInfo) {
        newsInfoService.update(newsInfo);
        return Result.success();
    }
    //检查
    @GetMapping("/{id}")
    public Result<NewsInfo> detail(@PathVariable Long id) {
        NewsInfo newsInfo = newsInfoService.findById(id);
        return Result.success(newsInfo);
    }
    //模糊查询
    @GetMapping("/find")
    public Result<List<NewsInfo>> find(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "5") Integer pageSize,
                                              HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<NewsInfo> list = (List<NewsInfo>) newsInfoService.findByNewsName(name);
        return Result.success(list);
    }

}
