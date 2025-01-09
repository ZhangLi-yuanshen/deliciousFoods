package com.example.dao;

import com.example.entity.CommentNotesInfo;
import com.example.entity.MessageInfo;
import com.example.vo.CommentNotesInfoVo;
import com.example.vo.MessageInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CommentNotesInfoDao extends Mapper<CommentNotesInfo> {

    List<CommentNotesInfoVo> findByName(@Param("name") String name);
    int checkRepeat(String column, String value, Long id);

    Integer count();

    void deleteById(Long id);
    int updateByMessage(CommentNotesInfoVo commentNotesInfoVo);
    List<CommentNotesInfo> findByForeignId (Long id);
}
