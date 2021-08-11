package com.chw.chw.workbench.web.controller;

import com.chw.chw.commons.contants.Contants;
import com.chw.chw.commons.domain.ReturnObject;
import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.commons.utils.UUIDUtils;
import com.chw.chw.settings.domain.User;
import com.chw.chw.workbench.domain.ClueRemark;
import com.chw.chw.workbench.service.ClueRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ClueRemarkController {
    @Autowired
    ClueRemarkService clueRemarkService;

    @RequestMapping("/workbench/clue/saveCreateClueRemark.do")
    public @ResponseBody
    Object saveCreateActivityRemark(ClueRemark remark, HttpSession session){
        User user=(User)session.getAttribute(Contants.SESSION_USER);
        //封装参数
        remark.setId(UUIDUtils.getUUID());
        remark.setCreateTime(DateUtils.formatDateTime(new Date()));
        remark.setCreateBy(user.getId());
        remark.setEditFlag("0");

        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法，保存市场活动 备注
            int ret=clueRemarkService.saveCreateActivityRemark(remark);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("保存线索备注成功");
                returnObject.setRetData(remark);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("保存线索备注失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("保存线索备注失败");
        }
        return returnObject;
    }
}
