package com.chw.chw.workbench.service;

import com.chw.chw.workbench.domain.Customer;
import com.chw.chw.workbench.domain.CustomerRemark;

import java.util.List;
import java.util.Map;

public interface CustomerRemarkService {

    List<CustomerRemark> queryCustomerRemarkForDetailByActivityId(String id);
}
