package com.example.controller;

import com.example.pojo.AdminInfo;
import com.example.service.AdminService;
import com.example.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    //登录
//    @PostMapping("/login")
//    public ResponseUtils login(HttpServletRequest request, @RequestBody AdminInfo adminInfo){
//        Integer login = adminService.login(adminInfo.getName(), adminInfo.getPassword());
//        if(login!=null){
//            request.getSession().setAttribute("user",);
//            ResponseUtils code = new ResponseUtils(200, "登录成功");
//            System.out.println(code);
//            return code;
//        }else {
//            return new ResponseUtils(404, "登录失败");
//        }
//    }

}
