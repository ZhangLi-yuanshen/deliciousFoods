package com.example.controller;

import com.example.common.Result;
import com.example.entity.CommentNotesInfo;
import com.example.service.NotesInfoCommentService;
import com.example.vo.NotesInfoCommentVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/notesInfoComment")
public class NotesInfoCommentController {
    @Resource
    private NotesInfoCommentService notesInfoCommentService;

    @PostMapping
    public Result<CommentNotesInfo> add(@RequestBody CommentNotesInfo commentInfo, HttpServletRequest request) {
        notesInfoCommentService.add(commentInfo, request);
        return Result.success(commentInfo);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        notesInfoCommentService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody CommentNotesInfo commentInfo) {
        notesInfoCommentService.update(commentInfo);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<CommentNotesInfo> detail(@PathVariable Long id) {
        CommentNotesInfo commentInfo = notesInfoCommentService.findById(id);
        return Result.success(commentInfo);
    }

    @GetMapping
    public Result<List<NotesInfoCommentVo>> all() {
        return Result.success(notesInfoCommentService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<NotesInfoCommentVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(notesInfoCommentService.findPage(name, pageNum, pageSize));
    }

    @GetMapping("/findByForeignId/{id}")
    public Result<List<CommentNotesInfo>> findByForeignId (@PathVariable Long id) {
        return Result.success(notesInfoCommentService.findByForeignId(id));
    }
}
