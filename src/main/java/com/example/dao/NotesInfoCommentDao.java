package com.example.dao;

import com.example.entity.CommentNotesInfo;
import com.example.vo.NotesInfoCommentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NotesInfoCommentDao extends Mapper<CommentNotesInfo> {
    List<NotesInfoCommentVo> findAllVo(@Param("name") String name);
    List<CommentNotesInfo> findByForeignId (Long id);
}
