package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.entity.MessageInfo;
import com.example.service.MessageInfoService;
import com.example.vo.MessageInfoVo;
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
@RequestMapping(value = "/messageInfo")
public class MessageInfoController {
    @Resource
    private MessageInfoService messageInfoService;
//新增
    @PostMapping
    public Result<MessageInfo> add(@RequestBody MessageInfoVo messageInfo) {
        messageInfoService.add(messageInfo);
        return Result.success(messageInfo);
    }
//删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        messageInfoService.delete(id);
        return Result.success();
    }
//修改
//    @PutMapping
//    public Result update(@RequestBody MessageInfoVo messageInfo) {
//        messageInfoService.update(messageInfo);
//        return Result.success();
//    }
@PutMapping
public Result update(@RequestBody MessageInfoVo messageInfo) {
    ;

    messageInfoService.updateByMessage(messageInfo);
    return Result.success();
}

    //根据id查询
    @GetMapping("/{id}")
    public Result<MessageInfo> detail(@PathVariable Long id) {
        MessageInfo messageInfo = messageInfoService.findById(id);
        return Result.success(messageInfo);
    }
//查询
    @GetMapping
    public Result<List<MessageInfoVo>> all() {
        return Result.success(messageInfoService.findAll());
    }
//分页查询
    @GetMapping("/page/{name}")
    public Result<PageInfo<MessageInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(messageInfoService.findPage(name, pageNum, pageSize, request));
    }
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("name", "张三");
        row.put("password", "123456");
        row.put("nickName", "昵称");
        row.put("sex", "男");
        row.put("age", 22);
        row.put("level", 1);

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=message.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
}