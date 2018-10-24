package com.lee.shriotest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @RequestMapping("/login")
    public Object test(){
        return "login";
    }
    @RequestMapping("/out")
    public Object test1(){
        return "out";
    }
}
