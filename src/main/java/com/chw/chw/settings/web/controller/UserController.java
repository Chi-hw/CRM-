package com.chw.chw.settings.web.controller;

import com.chw.chw.commons.contants.Contants;
import com.chw.chw.commons.domain.ReturnObject;
import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.settings.domain.User;
import com.chw.chw.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin(){
        return "settings/qx/user/login2";
    }

    @RequestMapping("/settings/qx/user/login.do")
    public @ResponseBody Object login(String loginAct, String loginPwd,String isRemPwd, HttpServletRequest req, HttpServletResponse resp, HttpSession session){

        Map<String,Object> map=new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        User user=userService.queryUserByLoginActandPwd(map);

        ReturnObject returnObject=new ReturnObject();
        if(user==null){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        }else{
            if (DateUtils.formatDateTime(new Date()).compareTo(user.getExpireTime())>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账户已过期");
            }else if(!user.getAllowIps().contains(req.getRemoteAddr())){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账户ip地址受限");
            }else if("0".equals(user.getLockState())){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账户被锁定");
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                session.setAttribute(Contants.SESSION_USER,user);
                if("true".equals(isRemPwd)){
                    Cookie c1=new Cookie("loginAct",loginAct);
                    c1.setMaxAge(60*60*24*10);
                    resp.addCookie(c1);
                    Cookie c2=new Cookie("loginPwd",loginPwd);
                    c1.setMaxAge(60*60*24*10);
                    resp.addCookie(c2);
                }else{
                    Cookie c1=new Cookie("loginAct","1");
                    c1.setMaxAge(0);
                    resp.addCookie(c1);
                    Cookie c2=new Cookie("loginPwd","1");
                    c1.setMaxAge(0);
                    resp.addCookie(c2);
                }
            }
        }

        return returnObject;
    }
    @RequestMapping("/settings/qx/user/logout.do")
    public String logout(HttpServletResponse resp,HttpSession session){
        Cookie c1=new Cookie("loginAct","1");
        c1.setMaxAge(0);
        resp.addCookie(c1);
        Cookie c2=new Cookie("loginPwd","1");
        c1.setMaxAge(0);
        resp.addCookie(c2);

        session.invalidate();

        return "redirect:/";
        //springmvc会转换成：response.sendRedirect("/chw")执行

    }

}
