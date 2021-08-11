package com.chw.chw.workbench.web.controller;

import com.chw.chw.workbench.domain.Contacts;
import com.chw.chw.workbench.domain.Customer;
import com.chw.chw.workbench.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @RequestMapping("/workbench/contacts/index.do")
    public String index(){
        return "workbench/contacts/index";
    }

    @RequestMapping("workbench/contacts/queryContactsForPageByCondition.do")
    public @ResponseBody Object queryContactsForPageByCondition(int pageNo, int pageSize, String contactsOwner, String name, String customername, String clueSource, String birth){
        Map<String,Object> map= new HashMap<>();
        map.put("beginNo",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("contactsOwner",contactsOwner);
        map.put("name",name);
        map.put("customername",customername);
        map.put("clueSource",clueSource);
        map.put("birth",birth);

        //查询出的数据列表
        List contactsList=contactsService.queryContactsForPageByCondition(map);

        //查询出的总条数
        long totalRows=contactsService.queryCountOfContactsByCondition(map);
        Map<String,Object> retMap=new HashMap<>();
        retMap.put("contactsList",contactsList);
        retMap.put("totalRows", totalRows);

        return retMap;
    }
}
