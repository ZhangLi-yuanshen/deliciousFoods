package com.example.controller;

import com.example.common.Result;
import com.example.service.AdminInfoServiceTest;
import com.example.util.ResponseUtils;
import com.example.vo.AdminVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class wxAdminInfoController {
    @Resource
    private AdminInfoServiceTest adminInfoService;
    //获取管理员信息
    @GetMapping
    public List<AdminVo> getAdminInfo(){
        return adminInfoService.selectAll();
    }
    //分页查询
    @GetMapping("/page/{name}")
    public Result<PageInfo<AdminVo>> page(@PathVariable String name,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                             HttpServletRequest request) {
        return Result.success(adminInfoService.findPage(name, pageNum, pageSize, request));
    }
    //根据id删除管理员信息
    @RequestMapping("/delete")
    public ResponseUtils delete(@RequestParam("id") Integer id){
        try {

            int result = adminInfoService.delete(id);
            if (result == 1){
                //删除成功
                return new ResponseUtils(200,"删除成功");
            }else {
                return new ResponseUtils(500,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"删除异常");
        }
    }
//    修改选中的管理员账号功能
    @RequestMapping("/update")
    public ResponseUtils update(@RequestBody AdminVo adminVo) {
        try {
            int result = adminInfoService.update(adminVo);
            if (result == 1) {
                return new ResponseUtils(200, "修改成功");
            } else {
                return new ResponseUtils(500, "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400, "修改异常");
        }
    }


    //新增
    @RequestMapping("/add")
    public ResponseUtils add(@RequestBody AdminVo adminVo){
        try {
            int result = adminInfoService.add(adminVo);
            if (result == 1){
                return new ResponseUtils(200,"新增成功");
            }else {
                return new ResponseUtils(500,"新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"新增异常");
        }
    }
}
