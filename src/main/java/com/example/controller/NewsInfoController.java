package com.example.controller;



import com.example.common.QueryRequest;
import com.example.common.Result;
import com.example.pojo.NewsInfo;
import com.example.service.impl.NewsInfoServiceImpl;
import com.example.util.PageResult;
import com.example.util.ResponseUtils;
import com.example.vo.NewsInfoVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/newsInfo")
public class NewsInfoController {
    @Resource
    private NewsInfoServiceImpl newsInfoService;
    // 获取所有新闻资讯（分页）
    @GetMapping("/page/{name}")
    public ResponseUtils list(@RequestBody QueryRequest queryRequest
                            , @PathVariable String name
                            , @RequestParam (defaultValue = "1") Integer pageNum
                            , @RequestParam (defaultValue = "5") Integer pageSize){
        PageResult<NewsInfo> newsInfoPageResult = newsInfoService.selectNewsInfoList(queryRequest,name,pageNum,pageSize);
        return new ResponseUtils(200,"success",newsInfoPageResult);
    }
    //查询所有咨询信息
    @GetMapping
    public Result<List<NewsInfoVo>> all(){return Result.success(newsInfoService.findAll());}

}