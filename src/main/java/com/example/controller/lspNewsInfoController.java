package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NewsInfo")
public class lspNewsInfoController {

    @Autowired
    private lspNewsInfoService lspNewsInfoService;
}