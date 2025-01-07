package com.example.controller;

import com.example.common.Result;
import com.example.entity.MessageInfo;
import com.example.service.MessageInfoService;
import com.example.vo.MessageInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}