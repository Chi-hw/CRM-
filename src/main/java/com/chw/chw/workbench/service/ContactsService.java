package com.chw.chw.workbench.service;

import com.chw.chw.workbench.domain.Contacts;
import com.chw.chw.workbench.domain.Customer;

import java.util.List;
import java.util.Map;

public interface ContactsService {
    List<Contacts> queryContactsByName(String contactsName);

    List<Contacts> getContacts();

    List queryContactsForPageByCondition(Map<String, Object> map);

    long queryCountOfContactsByCondition(Map<String, Object> map);

    Contacts queryContactsById(String id);
}
