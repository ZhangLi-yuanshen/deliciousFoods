package com.example.vo;

import com.example.entity.CommentNotesInfo;

public class NotesInfoCommentVo extends CommentNotesInfo {

    private String foreignName;

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }
}