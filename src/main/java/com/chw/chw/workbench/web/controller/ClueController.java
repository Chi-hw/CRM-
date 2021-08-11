package com.chw.chw.workbench.web.controller;

import com.chw.chw.commons.contants.Contants;
import com.chw.chw.commons.domain.ReturnObject;
import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.commons.utils.UUIDUtils;
import com.chw.chw.settings.domain.DicValue;
import com.chw.chw.settings.domain.User;
import com.chw.chw.settings.service.DicValueService;
import com.chw.chw.settings.service.UserService;
import com.chw.chw.workbench.domain.Activity;
import com.chw.chw.workbench.domain.Clue;
import com.chw.chw.workbench.domain.ClueActivityRelation;
import com.chw.chw.workbench.domain.ClueRemark;
import com.chw.chw.workbench.service.ActivityService;
import com.chw.chw.workbench.service.ClueActivityRelationService;
import com.chw.chw.workbench.service.ClueRemarkService;
import com.chw.chw.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ClueController {

    @Autowired
    private UserService userService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private ClueService clueService;

    @Autowired
    private ClueRemarkService clueRemarkService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ClueActivityRelationService clueActivityRelationService;


    @RequestMapping("/workbench/clue/index.do")
    public String index(Model model){
        List<User> userList=userService.getUser();
        List<DicValue> appllationList=dicValueService.queryDicValueByTypeCode("appellation");
        List<DicValue> clueStateList=dicValueService.queryDicValueByTypeCode("clueState");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");
        //数据保存到作用域中
        model.addAttribute("userList",userList);
        model.addAttribute("appllationList",appllationList);
        model.addAttribute("clueStateList",clueStateList);
        model.addAttribute("sourceList",sourceList);

        return "workbench/clue/index";
    }

    @RequestMapping("/workbench/clue/saveCreateClue.do")
    public @ResponseBody Object saveCreateClue(Clue clue, HttpSession session){
        User user=(User)session.getAttribute(Contants.SESSION_USER);
        //封装参数
        clue.setId(UUIDUtils.getUUID());
        clue.setCreateBy(user.getId());
        clue.setCreateTime(DateUtils.formatDateTime(new Date()));

        ReturnObject returnObject=new ReturnObject();
        try{
            int ret=clueService.saveCreateClue(clue);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("成功");
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("失败");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/clue/queryClueForPageByCondition.do")
    public @ResponseBody Object queryActivityForPageByCondition(int pageNo,int pageSize,String name,String owner,String mphone,String phone,String state,String source,String company){
        Map<String,Object> map= new HashMap<>();
        map.put("beginNo",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("mphone",mphone);
        map.put("phone",phone);
        map.put("state",state);
        map.put("source",source);
        map.put("company",company);
        map.put("owner",owner);

        //查询出的数据列表
        List<Clue> clueList=clueService.queryClueForPageByCondition(map);

        //查询出的总条数
        long totalRows=clueService.queryCountOfClueByCondition(map);
        Map<String,Object> retMap=new HashMap<>();
        retMap.put("clueList",clueList );

        retMap.put("totalRows", totalRows);
        return retMap;
    }

    @RequestMapping("/workbench/clue/detailClue.do")
    public String detailClue(String id,Model model){
        //调用service层方法，查询数据
        Clue clue=clueService.queryClueForDetailById(id);
        List<ClueRemark> remarkList=clueRemarkService.queryClueRemarkForDetailByClueId(id);
        List<Activity> activityList=activityService.queryActivityForDetailByClueId(id);
        //把数据保存到request中
        model.addAttribute("clue",clue);
        model.addAttribute("remarkList",remarkList);
        model.addAttribute("activityList",activityList);
        //请求转发
        return "workbench/clue/detail";
    }

    @RequestMapping("/workbench/clue/searchActivity.do")
    public @ResponseBody Object searchActivity(String activityName,String clueId){
        //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("activityName",activityName);
        map.put("clueId",clueId);
        //调用service层方法，查询市场活动
        List<Activity> activityList=activityService.queryActivityForDetailByNameClueId(map);
        //返回响应信息
        return activityList;//[{id:xxx,name:xxxx,....},{id:xxx,name:xxx,...},......]
    }
    @RequestMapping("/workbench/clue/saveBundActivity")
    public @ResponseBody Object saveBundActivity(String[] activityId,String clueId){
        //封装参数
        ClueActivityRelation relation=null;
        List<ClueActivityRelation> relationList=new ArrayList<>();
        for(String ai:activityId){
            relation=new ClueActivityRelation();
            relation.setId(UUIDUtils.getUUID());
            relation.setActivityId(ai);
            relation.setClueId(clueId);
            relationList.add(relation);
        }

        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法，保存线索和市场活动的关联关系
            int ret=clueActivityRelationService.saveCreateClueActivityRelationByList(relationList);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                //查询activityId市场活动的信息
                List<Activity> activityList=activityService.queryActivityForDetailByIds(activityId);
                returnObject.setRetData(activityList);
                returnObject.setMessage("关联市场活动成功");
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("关联市场活动失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("关联市场活动失败");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/clue/saveUnbundActivity.do")
    public @ResponseBody Object saveUnbundActivity(ClueActivityRelation relation){
        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法，删除线索和市场活动的关联关系
            int ret=clueActivityRelationService.deleteClueActivityRelationByClueIdActivityId(relation);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("解除市场活动关联成功.");
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("解除市场活动关联失败.");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("解除市场活动关联失败");
        }
        return returnObject;
    }
    @RequestMapping("/workbench/clue/convertClue.do")
    public String convertClue(String id,Model model){
        //调用service层方法，查询数据
        Clue clue=clueService.queryClueForDetailById(id);
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        //把数据保存到request中
        model.addAttribute("clue",clue);
        model.addAttribute("stageList",stageList);
        //请求转发
        return "workbench/clue/convert";
    }


    @RequestMapping("/workbench/clue/queryActivityForDetailByName.do")
    public @ResponseBody Object queryActivityForDetailByName(String activityName){
        //调用service层方法，查询市场活动
        List<Activity> activityList=activityService.queryActivityForDetailByName(activityName);
        //返回响应信息
        return activityList;
    }

    @RequestMapping("/workbench/clue/saveConvertClue.do")
    public @ResponseBody Object saveConvertClue(String clueId,String isCreateTran,String amountOfMoney,String tradeName,String expectedClosingDate,
                                                String stage,String activityId,HttpSession session){
        //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("clueId",clueId);
        map.put("isCreateTran",isCreateTran);
        map.put("amountOfMoney",amountOfMoney);
        map.put("tradeName",tradeName);
        map.put("expectedClosingDate",expectedClosingDate);
        map.put("stage",stage);
        map.put("activityId",activityId);
        map.put("sessionUser",session.getAttribute(Contants.SESSION_USER));

        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法，保存线索转换
            clueService.saveConvert(map);
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("转换成功");

        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("转换失败");
        }
        return returnObject;
    }
}
