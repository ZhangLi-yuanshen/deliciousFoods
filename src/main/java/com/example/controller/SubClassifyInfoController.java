package com.example.controller;


import com.example.common.Result;
import com.example.entity.SubClassifyInfo;
import com.example.service.SubClassifyInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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



    /**
     * 查询菜谱小类信息列表
     */
    @GetMapping()
    @ResponseBody
    public Result<PageInfo<SubClassifyInfo>>  list(@RequestParam(defaultValue = "1") Integer pageNum,
                                                   @RequestParam(defaultValue = "5") Integer pageSize,
                                                   SubClassifyInfo subClassifyInfo)
    {
        return Result.success(subClassifyInfoService.selectSubClassifyInfoList(pageNum, pageSize,subClassifyInfo));

    }



    /**
     * 新增保存菜谱小类信息
     */
    @PostMapping()
    @ResponseBody
    public Result addSave(@RequestBody SubClassifyInfo subClassifyInfo)
    {
        return Result.success(subClassifyInfoService.insertSubClassifyInfo(subClassifyInfo));
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
