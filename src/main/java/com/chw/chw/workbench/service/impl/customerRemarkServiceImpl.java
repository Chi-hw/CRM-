package com.chw.chw.workbench.service.impl;

import com.chw.chw.workbench.domain.Customer;
import com.chw.chw.workbench.domain.CustomerRemark;
import com.chw.chw.workbench.mapper.CustomerMapper;
import com.chw.chw.workbench.mapper.CustomerRemarkMapper;
import com.chw.chw.workbench.service.CustomerRemarkService;
import com.chw.chw.workbench.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("customerRemarkService")
public class customerRemarkServiceImpl implements CustomerRemarkService {
    @Autowired
    private CustomerRemarkMapper customerRemarkMapper;


    @Override
    public List<CustomerRemark> queryCustomerRemarkForDetailByActivityId(String id) {
        return customerRemarkMapper.selectCustomerRemarkForDetailByActivityId(id);
    }
}
