package com.chw.chw.workbench.web.controller;

import com.chw.chw.commons.contants.Contants;
import com.chw.chw.commons.domain.ReturnObject;
import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.commons.utils.UUIDUtils;
import com.chw.chw.settings.domain.DicValue;
import com.chw.chw.settings.domain.User;
import com.chw.chw.settings.service.DicValueService;
import com.chw.chw.settings.service.UserService;
import com.chw.chw.workbench.domain.*;
import com.chw.chw.workbench.service.CustomerService;
import com.chw.chw.workbench.service.TranHistoryService;
import com.chw.chw.workbench.service.TranRemarkService;
import com.chw.chw.workbench.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class TranController {
    @Autowired
    private UserService userService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TranService tranService;

    @Autowired
    private TranRemarkService tranRemarkService;

    @Autowired
    private TranHistoryService tranHistoryService;

    @RequestMapping("workbench/transaction/queryTranForPageByCondition.do")
    public @ResponseBody Object queryContactsForPageByCondition(int pageNo, int pageSize, String transctionOwner, String transctionname, String transctioncustomerName, String transctionstate, String transctionkinds, String transctionSource, String transctionconstacts){
        Map<String,Object> map= new HashMap<>();
        map.put("beginNo",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("transctionOwner",transctionOwner);
        map.put("transctionname",transctionname);
        map.put("transctioncustomerName",transctioncustomerName);
        map.put("transctionstate",transctionstate);
        map.put("transctionkinds",transctionkinds);
        map.put("transctionSource",transctionSource);
        map.put("transctionconstacts",transctionconstacts);

        //查询出的数据列表
        List<TranVo> tranList=tranService.queryTranForPageByCondition(map);
        //查询出的总条数
        long totalRows=tranService.queryCountOfTranByCondition(map);
        Map<String,Object> retMap=new HashMap<>();
        retMap.put("tranList",tranList);
        retMap.put("totalRows", totalRows);

        return retMap;
    }

    @RequestMapping("/workbench/transaction/index.do")
    public String index(Model model){
        //调用service层方法，查询动态数据
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        List<DicValue> transactionTypeList=dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");
        //把数据保存到request中
        model.addAttribute("stageList",stageList);
        model.addAttribute("transactionTypeList",transactionTypeList);
        model.addAttribute("sourceList",sourceList);
        //请求转发
        return "workbench/transaction/index";
    }


    @RequestMapping("/workbench/transaction/createTran.do")
    public String createTran(Model model){
        //调用service层方法，查询动态数据
        List<User> userList=userService.getUser();
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        List<DicValue> transactionTypeList=dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");
        //把数据保存到request中
        model.addAttribute("userList",userList);
        model.addAttribute("stageList",stageList);
        model.addAttribute("transactionTypeList",transactionTypeList);
        model.addAttribute("sourceList",sourceList);
        //请求转发
        return "workbench/transaction/save";
    }

    @RequestMapping("/workbench/transaction/getPossibilityByStageValue.do")
    public @ResponseBody Object getPossibilityByStageValue(String stageValue){
        //解析properties配置，获取可能性   ResourceBundle读取配置文件
        ResourceBundle bundle=ResourceBundle.getBundle("possibility");
        String possibility=bundle.getString(stageValue);
        return possibility;
    }
    @RequestMapping("/workbench/transaction/queryCustomerByName.do")
    public @ResponseBody Object queryCustomerByName(String customerName){
        //调用service层方法，查询客户
        List<Customer> customerList=customerService.queryCustomerByName(customerName);
        return customerList;
    }
    @RequestMapping("/workbench/transaction/saveCreateTran.do")
    public @ResponseBody Object saveCreateTran(Tran tran, String customerName, HttpSession session){
        User user=(User)session.getAttribute(Contants.SESSION_USER);
        //封装参数
        tran.setId(UUIDUtils.getUUID());
        tran.setCreateBy(user.getId());
        tran.setCreateTime(DateUtils.formatDateTime(new Date()));

        Map<String,Object> map=new HashMap<>();
        map.put("tran",tran);
        map.put("customerName",customerName);
        map.put("sessionUser",user);

        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法，保存数据
            tranService.saveCreateTran(map);
            returnObject.setMessage("成功");
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("保存失败");
        }

        return returnObject;
    }
    @RequestMapping("/workbench/transaction/typeahead.do")
    public @ResponseBody Object typeahead(String customerName){
        //调用service层方法，根据customerName模糊查询可以的名称，List<String>
        /*List<String> list=new ArrayList<>();
        list.add("动力节点");
        list.add("字节跳动");
        list.add("动XXXXX");
        list.add("动YYYYY");*/

        List<Customer> customerList=new ArrayList<>();
        Customer customer=new Customer();
        customer.setId("1001");
        customer.setName("阿里巴巴");
        customerList.add(customer);
        customer=new Customer();
        customer.setId("1002");
        customer.setName("字节跳动");
        customerList.add(customer);
        customer=new Customer();
        customer.setId("1003");
        customer.setName("腾讯");
        customerList.add(customer);
        customer=new Customer();
        customer.setId("1004");
        customer.setName("京东");
        customerList.add(customer);

        return customerList;// [{id:'1001',name:'动力节点',...},{id:'1002',name:'字节跳动',....},.......]
    }

    @RequestMapping("/workbench/transaction/detailTransacttion.do")
    public String detailTran(String id,Model model){
        //调用service层方法，查询数据
        Tran tran=tranService.queryTranForDetailById(id);
        List<TranRemark> remarkList=tranRemarkService.queryTranRemarkForDetailByTranId(id);
        List<TranHistory> tranHistoryList=tranHistoryService.queryTranHistoryForDetailByTranId(id);

        //解析possibility配置文件，根据交易阶段的名称获取可能性
        ResourceBundle bundle=ResourceBundle.getBundle("possibility");
        String possibility=bundle.getString(tran.getStage());
        tran.setPossibility(possibility);

        //把数据保存到request中
        model.addAttribute("tran",tran);
        model.addAttribute("remarkList",remarkList);
        model.addAttribute("tranHistoryList",tranHistoryList);
        //model.addAttribute("possibility",possibility);

        //为了显示交易的图标信息，查询交易阶段的所有信息
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        model.addAttribute("stageList",stageList);
        //model.addAttribute("stageListLength",stageList.size());

        //获取失败之前最后一个非失败阶段的orderNo
        TranHistory tranHistory=null;
        for(int i=tranHistoryList.size()-1;i>=0;i--){
            tranHistory=tranHistoryList.get(i);
            if(Integer.parseInt(tranHistory.getOrderNo())<Integer.parseInt(stageList.get(stageList.size()-3).getOrderNo())){
                //tranHistory的orderNo保存到作用域中
                model.addAttribute("theOrderNo",tranHistory.getOrderNo());
                break;
            }
        }

        //请求转发
        return "workbench/transaction/detail";
    }
}
