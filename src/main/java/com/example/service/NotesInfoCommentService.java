package com.example.service;

import com.example.dao.NotesInfoCommentDao;
import com.example.entity.Account;
import com.example.entity.CommentNotesInfo;
import com.example.exception.CustomException;
import com.example.vo.NotesInfoCommentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NotesInfoCommentService {

    @Resource
    private NotesInfoCommentDao notesInfoCommentDao;

    public CommentNotesInfo add(CommentNotesInfo commentInfo, HttpServletRequest request) {
        Account user = (Account) request.getSession().getAttribute("user");
        if (user == null) {
            throw new CustomException("1001", "请先登录！");
        }
        commentInfo.setName(user.getName());
        commentInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        notesInfoCommentDao.insertSelective(commentInfo);
        return commentInfo;
    }

    public void delete(Long id) {
        notesInfoCommentDao.deleteByPrimaryKey(id);
    }

    public void update(CommentNotesInfo commentInfo) {
        commentInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        notesInfoCommentDao.updateByPrimaryKeySelective(commentInfo);
    }

    public CommentNotesInfo findById(Long id) {
        return notesInfoCommentDao.selectByPrimaryKey(id);
    }

    public List<NotesInfoCommentVo> findAll() {
        return notesInfoCommentDao.findAllVo(null);
    }

    public PageInfo<NotesInfoCommentVo> findPage(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<NotesInfoCommentVo> all = notesInfoCommentDao.findAllVo(name);
        return PageInfo.of(all);
    }

    public List<CommentNotesInfo> findByForeignId (Long id) {
        return notesInfoCommentDao.findByForeignId(id);
    }
}
