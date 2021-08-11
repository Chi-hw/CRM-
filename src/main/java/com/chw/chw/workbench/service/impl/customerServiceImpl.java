package com.chw.chw.workbench.service.impl;

import com.chw.chw.workbench.domain.Customer;
import com.chw.chw.workbench.mapper.CustomerMapper;
import com.chw.chw.workbench.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("customerService")
public class customerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> queryCustomerByName(String name) {
        return customerMapper.selectCustomerByName(name);
    }

    @Override
    public List<Customer> getCustomer() {
        List<Customer> clist=customerMapper.selectCustomer();
        return clist;
    }

    @Override
    public List<Customer> queryCustomerForPageByCondition(Map<String, Object> map) {

        return customerMapper.selectCustomerForPageByCondition(map);
    }

    @Override
    public long queryCountOfCustomerByCondition(Map<String, Object> map) {
        return customerMapper.selectCountofCustomer(map);
    }

    @Override
    public Customer queryCustomerById(String id) {
        return customerMapper.selectByPrimaryKey(id);
    }
}
