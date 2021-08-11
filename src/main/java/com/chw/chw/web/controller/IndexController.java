
package com.chw.chw.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /*
    ModelandView既要返回数据，又要跳转到页面
    String：只需要跳转页面，不需要返回数据
    obj：返回json
    void:不需要返回跳转页面，也不需要返回json字符串
     */
    @RequestMapping("/")
    public String index(){
        //......拦截器，当访问地址为localhost:8080:chw/时
        //返回index页面，而index页面返回的是登录页面地址
        return "index";
    }
}
