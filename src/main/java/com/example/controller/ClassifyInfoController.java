package com.example.controller;

import com.example.common.Result;
import com.example.entity.ClassifyInfo;
import com.example.service.ClassifyInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * 菜谱大类信息Controller
 *
 * @author dong
 *
 */
@Controller
@RequestMapping("/classifyInfo")
public class ClassifyInfoController
{

    @Autowired
    private ClassifyInfoService classifyInfoService;



    /**
     * 查询菜谱大类信息列表
     */
    @GetMapping("/page/all")
    @ResponseBody
    public Result<PageInfo<ClassifyInfo>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                               ClassifyInfo classifyInfo)
    {
       return Result.success(classifyInfoService.selectClassifyInfoList(pageNum, pageNum,classifyInfo));
    }



    /**
     * 新增保存菜谱大类信息
     */
    @PostMapping()
    @ResponseBody
    public Result addSave(@RequestBody ClassifyInfo classifyInfo)
    {
        return Result.success(classifyInfoService.insertClassifyInfo(classifyInfo));
    }



    /**
     * 修改保存菜谱大类信息
     */
    @PutMapping()
    @ResponseBody
    public Result editSave(@RequestBody ClassifyInfo classifyInfo)
    {
        return Result.success(classifyInfoService.updateClassifyInfo(classifyInfo));
    }

    /**
     * 删除菜谱大类信息
     */
    @DeleteMapping( "/{id}")
    @ResponseBody
    public Result remove(@PathVariable Long id)
    {
        return Result.success(classifyInfoService.deleteClassifyInfoById(id));
    }

    /**
     * 下载模板文件
     * @return Result
     */
    @GetMapping("/getExcelModel")
    @ResponseBody
    public  ResponseEntity<Resource> getExcelModel()
    {
        // 加载文件
        Resource resource = new ClassPathResource("static/file/excelTemplate/菜谱大类导入模板.xlsx");
        if (!resource.exists()) {
            // 如果文件不存在，返回 404 错误
            return ResponseEntity.notFound().build();
        }
        // 编码文件名，以避免中文乱码问题
        String encodedFileName = encodeFileName(resource.getFilename());

        // 设置文件下载的响应头
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + encodedFileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM) // 指定为下载文件
                .body(resource);
    }
    @PostMapping("/upload")
    @ResponseBody
    public Result uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            // 调用服务类处理文件
            classifyInfoService.importExcelData(file.getInputStream());
            return Result.success("文件导入成功");
        } catch (Exception e) {
            return Result.error("500","文件导入失败：" + e.getMessage());
        }
    }

    private String encodeFileName(String fileName)   {
        try {
            // 使用 UTF-8 对文件名进行编码
            if (fileName == null) {
                return "";
            }
            String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
            // 替换 URL 编码中的加号为 %20（避免出现空格变加号的情况）
            encodedFileName = encodedFileName.replaceAll("\\+", "%20");
            return encodedFileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
