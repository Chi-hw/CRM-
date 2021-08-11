package com.chw.chw.workbench.web.controller;

import com.chw.chw.workbench.domain.FunnelVO;
import com.chw.chw.workbench.service.ActivityService;
import com.chw.chw.workbench.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChartController {
    @Autowired
    private TranService tranService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workench/chart/transaction/index.do")
    public String index(){
        return "workbench/chart/transaction/index";
    }

    @RequestMapping("/workench/chart/transaction/queryCountOfTranGroupByStage.do")
    public @ResponseBody Object queryCountOfTranGroupByStage(){
        //调用service层方法，查询交易表中各个阶段的数据量
        List<FunnelVO> funnelVOList=tranService.queryCountOfTranGroupByStage();
        return funnelVOList;
    }

    @RequestMapping("/workench/chart/activity/index1")
    public String index1(){
        return "workbench/chart/activity/index";
    }

    @RequestMapping("/workench/chart/activity/queryCountOfActivityGroupByStage.do")
    public @ResponseBody Object queryCountOfActivityGroupByStage(){
        List<FunnelVO> funnelVOList=activityService.queryCountOfActivity();
        return  funnelVOList;
    }

}
