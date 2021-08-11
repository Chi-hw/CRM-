package com.chw.chw.workbench.service;

import com.chw.chw.workbench.domain.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> queryCustomerByName(String customerName);

    List<Customer> getCustomer();

    List<Customer> queryCustomerForPageByCondition(Map<String, Object> map);

    long queryCountOfCustomerByCondition(Map<String, Object> map);

    Customer queryCustomerById(String id);
}
