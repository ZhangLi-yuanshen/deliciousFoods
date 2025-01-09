package com.example.controller;

import com.example.common.Result;
import com.example.entity.CommentNotesInfo;
import com.example.entity.MessageInfo;
import com.example.service.CommentNotesInfoService;
import com.example.service.MessageInfoService;
import com.example.vo.CommentNotesInfoVo;
import com.example.vo.MessageInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/notesInfoComment")
public class CommentNotesInfoController {
    @Resource
    private CommentNotesInfoService commentNotesInfoService;
//新增
    @PostMapping
    public Result<CommentNotesInfo> add(@RequestBody CommentNotesInfoVo commentNotesInfo) {
        commentNotesInfoService.add(commentNotesInfo);
        return Result.success(commentNotesInfo);
    }
//删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        commentNotesInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody CommentNotesInfoVo commentNotesInfo) {
        commentNotesInfoService.updateByMessage(commentNotesInfo);
        return Result.success();
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result<CommentNotesInfo> detail(@PathVariable Long id) {
        CommentNotesInfo commentNotesInfo = commentNotesInfoService.findById(id);
        return Result.success(commentNotesInfo);
    }
//查询
    @GetMapping
    public Result<List<CommentNotesInfoVo>> all() {
        return Result.success(commentNotesInfoService.findAll());
    }
//分页查询
    @GetMapping("/page/{name}")
    public Result<PageInfo<CommentNotesInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(commentNotesInfoService.findPage(name, pageNum, pageSize, request));
    }
    @GetMapping("/findByForeignId/{id}")
    public Result<List<CommentNotesInfo>> findByForeignId (@PathVariable Long id) {
        List<CommentNotesInfo> byForeignId = commentNotesInfoService.findByForeignId(id);
        return Result.success(byForeignId);
    }
}