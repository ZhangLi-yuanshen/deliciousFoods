package com.example.service;

import com.example.common.Result;
import com.example.dao.CommentNotesInfoDao;
import com.example.dao.MessageInfoDao;
import com.example.entity.CommentNotesInfo;
import com.example.entity.MessageInfo;
import com.example.vo.CommentNotesInfoVo;
import com.example.vo.MessageInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CommentNotesInfoService {

    @Resource
    private CommentNotesInfoDao commentNotesInfoDao;

    public CommentNotesInfo add(CommentNotesInfo commentNotesInfo) {
        commentNotesInfoDao.insertSelective(commentNotesInfo);
        return commentNotesInfo;
    }

    public void delete(Long id) {
//        messageInfoDao.deleteByPrimaryKey(id);
        commentNotesInfoDao.deleteById(id);
    }

//    public void update(MessageInfo messageInfo) {
//        messageInfoDao.updateByPrimaryKeySelective(messageInfo);
//    }

    public Result<CommentNotesInfoVo> updateByMessage(@RequestBody CommentNotesInfoVo commentNotesInfoVo) {
        commentNotesInfoDao.updateByMessage(commentNotesInfoVo);
        return Result.success(commentNotesInfoVo);
    }


    public CommentNotesInfo findById(Long id) {
        return commentNotesInfoDao.selectByPrimaryKey(id);
    }

    public List<CommentNotesInfoVo> findAll() {
        return commentNotesInfoDao.findByName("all");
    }

    public PageInfo<CommentNotesInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<CommentNotesInfoVo> all = findAllPage(request, name);
        return PageInfo.of(all);
    }

    public List<CommentNotesInfoVo> findAllPage(HttpServletRequest request, String name) {
        return commentNotesInfoDao.findByName(name);
    }


    public List<CommentNotesInfo> findByForeignId(Long id) {
        return commentNotesInfoDao.findByForeignId(id);
    }
}