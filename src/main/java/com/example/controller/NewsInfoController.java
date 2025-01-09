package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.entity.NewsInfo;
import com.example.service.NewsInfoService;
import com.example.vo.NewsInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        newsInfoService.updateById(newsInfo);
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
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<NewsInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(NewsInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<NewsInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getName())).collect(Collectors.toList());
            for (NewsInfo info : resultList) {
                newsInfoService.add(info);
            }
        }
        return Result.success();
    }

    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("name", "");
        row.put("content", "");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=newsInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
}
