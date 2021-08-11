package com.chw.chw.workbench.service.impl;

import com.chw.chw.workbench.domain.Contacts;
import com.chw.chw.workbench.domain.Customer;
import com.chw.chw.workbench.domain.CustomerRemark;
import com.chw.chw.workbench.mapper.ContactsMapper;
import com.chw.chw.workbench.mapper.ContactsRemarkMapper;
import com.chw.chw.workbench.mapper.CustomerRemarkMapper;
import com.chw.chw.workbench.service.ContactsService;
import com.chw.chw.workbench.service.CustomerRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("contactsService")
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public List<Contacts> queryContactsByName(String contactsName) {
        return contactsMapper.selectContactsByName(contactsName);
    }

    @Override
    public List<Contacts> getContacts() {
        List<Contacts> contactslist=contactsMapper.selectCustomer();
        return contactslist;
    }

    @Override
    public List queryContactsForPageByCondition(Map<String, Object> map) {
        return contactsMapper.selectContactsForPageByCondition(map);
    }

    @Override
    public long queryCountOfContactsByCondition(Map<String, Object> map) {
        return contactsMapper.selectCountofContacts(map);
    }

    @Override
    public Contacts queryContactsById(String id) {
        return contactsMapper.selectByPrimaryKey(id);
    }
}
