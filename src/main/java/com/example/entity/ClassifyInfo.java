package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 菜谱大类信息对象 classify_info
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Classify_info")
public class ClassifyInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 名称 */
    private String name;

    /** 描述 */
    private String descroiption;


}
