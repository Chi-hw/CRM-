package com.chw.chw.workbench.web.controller;

import com.chw.chw.workbench.domain.Customer;
import com.chw.chw.workbench.domain.CustomerRemark;
import com.chw.chw.workbench.mapper.CustomerRemarkMapper;
import com.chw.chw.workbench.service.CustomerRemarkService;
import com.chw.chw.workbench.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRemarkService customerRemarkService;

    @RequestMapping("/workbench/customer/index.do")
    public String index(Model model){
        List<Customer> clist=customerService.getCustomer();
        model.addAttribute("clist",clist);
        return "workbench/customer/index";
    }
    @RequestMapping("/workbench/customer/queryCustomerForPageByCondition.do")
    public @ResponseBody Object queryActivityForPageByCondition(int pageNo, int pageSize, String name, String owner, String phone, String web){
        Map<String,Object> map= new HashMap<>();
        map.put("beginNo",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("owner",owner);
        map.put("phone",phone);
        map.put("web",web);
        //查询出的数据列表
        List<Customer> customerList=customerService.queryCustomerForPageByCondition(map);
        //查询出的总条数
        long totalRows=customerService.queryCountOfCustomerByCondition(map);
        Map<String,Object> retMap=new HashMap<>();
        retMap.put("customerList",customerList);
        retMap.put("totalRows", totalRows);

        return retMap;
    }
    @RequestMapping("/workbench/customer/detailCustomer.do")
    public String detailCustomer(String id,Model model){
        Customer customer=customerService.queryCustomerById(id);
        List<CustomerRemark> remarkList=customerRemarkService.queryCustomerRemarkForDetailByActivityId(id);
        model.addAttribute("customer",customer);
        model.addAttribute("remarkList",remarkList);
        return "workbench/customer/detail";
    }
}
