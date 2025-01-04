package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AuthorityInfo {
    private Integer level;
    private String name;
    private List<Model> models;

    @Setter
    @Getter
    public static class Model {
        private Integer modelId;
        private List<Integer> operation;

    }
}
