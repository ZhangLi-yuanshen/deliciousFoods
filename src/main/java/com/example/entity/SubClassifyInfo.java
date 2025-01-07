package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 菜谱小类信息对象 sub_classify_info
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_classify_info")
public class SubClassifyInfo
{

    /** ID */
    private Long id;

    /** 名称 */
    private String name;

    /** 描述 */
    private String description;

    /** 菜谱大类id */
    private Long classifyId;


}
