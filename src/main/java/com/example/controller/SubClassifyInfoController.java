package com.example.controller;


import com.example.common.Result;
import com.example.entity.ClassifyInfo;
import com.example.entity.SubClassifyInfo;
import com.example.service.ClassifyInfoService;
import com.example.service.SubClassifyInfoService;
import com.example.vo.SubClassifyInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 菜谱小类信息Controller
 * @author dong
 *
 */
@Controller
@RequestMapping("/subClassifyInfo")
public class SubClassifyInfoController
{


    @Autowired
    private SubClassifyInfoService subClassifyInfoService;
    @Resource
    private ClassifyInfoService classifyInfoService;



    /**
     * 查询菜谱小类信息列表
     */
    @GetMapping("/page/all")
    @ResponseBody
    public Result<PageInfo<SubClassifyInfo>>  list(@RequestParam(defaultValue = "1") Integer pageNum,
                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                   SubClassifyInfo subClassifyInfo)
    {
        return Result.success(subClassifyInfoService.selectSubClassifyInfoList(pageNum, pageSize,subClassifyInfo));

    }
    //计数
    @GetMapping
    public Result<List<SubClassifyInfoVo>> count() {
        return Result.success(subClassifyInfoService.findAll());
    }

    /**
     * 新增保存菜谱小类信息
     */
    @PostMapping()
    @ResponseBody
    public Result addSave(@RequestBody SubClassifyInfo subClassifyInfoVo)
    {
        return Result.success(subClassifyInfoService.insertSubClassifyInfo(subClassifyInfoVo));
    }



    /**
     * 修改保存菜谱小类信息
     */
    @PutMapping("")
    @ResponseBody
    public Result editSave(@RequestBody SubClassifyInfo subClassifyInfo)
    {
        return Result.success(subClassifyInfoService.updateSubClassifyInfo(subClassifyInfo));
    }

    /**
     * 删除菜谱小类信息
     */
    @DeleteMapping( "/{id}")
    @ResponseBody
    public Result remove(@PathVariable Long id)
    {
        return Result.success(subClassifyInfoService.deleteSubClassifyInfoById(id));
    }


}
