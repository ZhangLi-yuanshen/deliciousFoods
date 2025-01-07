package com.example.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.example.dao.ClassifyInfoDao;
import com.example.entity.ClassifyInfo;
import com.example.service.ClassifyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 菜谱大类信息Service业务层处理
 *
 * @author dong
 *
 */
@Service
public class ClassifyInfoServiceImpl implements ClassifyInfoService
{
    @Autowired
    private ClassifyInfoDao classifyInfoDao;

    /**
     * 查询菜谱大类信息
     *
     * @param id 菜谱大类信息主键
     * @return 菜谱大类信息
     */
    @Override
    public ClassifyInfo selectClassifyInfoById(Long id)
    {
        return classifyInfoDao.selectClassifyInfoById(id);
    }

    /**
     * 查询菜谱大类信息列表
     *
     * @param classifyInfo 菜谱大类信息
     * @return 菜谱大类信息
     */
    @Override
    public PageInfo<ClassifyInfo> selectClassifyInfoList(Integer pageNum, Integer pageSize,ClassifyInfo classifyInfo)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<ClassifyInfo> all = classifyInfoDao.selectClassifyInfoList(classifyInfo);
        return PageInfo.of(all);
    }

    /**
     * 新增菜谱大类信息
     *
     * @param classifyInfo 菜谱大类信息
     * @return 结果
     */
    @Override
    public int insertClassifyInfo(ClassifyInfo classifyInfo)
    {
        return classifyInfoDao.insertClassifyInfo(classifyInfo);
    }

    /**
     * 修改菜谱大类信息
     *
     * @param classifyInfo 菜谱大类信息
     * @return 结果
     */
    @Override
    public int updateClassifyInfo(ClassifyInfo classifyInfo)
    {
        return classifyInfoDao.updateClassifyInfo(classifyInfo);
    }



    /**
     * 删除菜谱大类信息信息
     *
     * @param id 菜谱大类信息主键
     * @return 结果
     */
    @Override
    public int deleteClassifyInfoById(Long id)
    {
        return classifyInfoDao.deleteClassifyInfoById(id);
    }

    @Override
    public void importExcelData(InputStream inputStream) {
        try (Workbook workbook = new XSSFWorkbook(inputStream);){
              // 创建 Excel 工作簿对象
            Sheet sheet = workbook.getSheetAt(0);  // 获取第一个 sheet 页
            Iterator<Row> rowIterator = sheet.iterator();  // 获取行的迭代器

            List<ClassifyInfo> menuCategories = new ArrayList<>();

            // 跳过标题行
            if (rowIterator.hasNext()) {
                rowIterator.next();  // 跳过标题行
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell nameCell = row.getCell(0); // name 列（假设在第 0 列）
                Cell codeCell = row.getCell(1); // code 列（假设在第 1 列）

                if (nameCell != null && codeCell != null) {
                    ClassifyInfo category = new ClassifyInfo();
                    category.setName(nameCell.getStringCellValue());  // 获取 name 字段
                    category.setDescroiption(codeCell.getStringCellValue());  // 获取 code 字段
                    menuCategories.add(category);
                }
            }

            // 保存到数据库
            for(ClassifyInfo category : menuCategories){
                classifyInfoDao.insertClassifyInfo(category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ClassifyInfo> all(ClassifyInfo classifyInfo) {
        return classifyInfoDao.selectClassifyInfoList(classifyInfo);
    }
}
