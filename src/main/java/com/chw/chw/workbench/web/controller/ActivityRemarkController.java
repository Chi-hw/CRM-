package com.chw.chw.workbench.web.controller;


import com.chw.chw.commons.contants.Contants;
import com.chw.chw.commons.domain.ReturnObject;
import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.commons.utils.UUIDUtils;
import com.chw.chw.settings.domain.User;
import com.chw.chw.workbench.domain.ActivityRemark;
import com.chw.chw.workbench.service.ActivityRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ActivityRemarkController {
    @Autowired
    private ActivityRemarkService activityRemarkService;

    @RequestMapping("/workbench/activity/saveCreateActivityRemark.do")
    public @ResponseBody Object saveCreateActivityRemark(ActivityRemark remark, HttpSession session){
        User user= (User) session.getAttribute(Contants.SESSION_USER);
        //封装参数
        remark.setId(UUIDUtils.getUUID());
        remark.setCreateTime(DateUtils.formatDateTime(new Date()));
        remark.setCreateBy(user.getId());
        remark.setEditFlag("0");
        ReturnObject returnObject=new ReturnObject();
        try{
            int ret=activityRemarkService.saveCreateActivityRemark(remark);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("插入备注成功");
                returnObject.setRetData(remark);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("插入数据失败");

            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("插入数据失败");
        }
        return  returnObject;
    }
    @RequestMapping("/workbench/activity/deleteActivityRemarkById.do")
    public @ResponseBody Object deleteActivityRemarkById(String id){
        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法，删除市场活动备注
            int ret=activityRemarkService.deleteActivityRemarkById(id);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("删除市场活动备注成功");
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("删除市场活动备注失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除市场活动备注失败");
        }
        return returnObject;
    }
    @RequestMapping("/workbench/activity/saveEditActivityRemark.do")
    public  @ResponseBody Object saveEditActivityRemark(ActivityRemark remark,HttpSession session){
        User user= (User) session.getAttribute(Contants.SESSION_USER);
        //封装参数
        remark.setEditFlag("1");
        remark.setEditTime(DateUtils.formatDateTime(new Date()));
        remark.setEditBy(user.getId());
        ReturnObject returnObject=new ReturnObject();
        try {
            int ret=activityRemarkService.saveEditActivityRemark(remark);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setRetData(remark);
                returnObject.setMessage("修改备注信息成功");

            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("修改备注信息错误");
            }

        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("修改备注信息错误");
        }
        return returnObject;
    }

}
