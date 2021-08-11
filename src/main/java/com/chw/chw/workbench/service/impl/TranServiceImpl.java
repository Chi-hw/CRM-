package com.chw.chw.workbench.service.impl;

import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.commons.utils.UUIDUtils;
import com.chw.chw.settings.domain.User;
import com.chw.chw.workbench.domain.*;
import com.chw.chw.workbench.mapper.CustomerMapper;
import com.chw.chw.workbench.mapper.TranHistoryMapper;
import com.chw.chw.workbench.mapper.TranMapper;
import com.chw.chw.workbench.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tranService")
public class TranServiceImpl implements TranService {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private TranMapper tranMapper;

    @Autowired
    private TranHistoryMapper tranHistoryMapper;

    @Override
    public int saveCreateTran(Map<String, Object> map) {
        Tran tran=(Tran)map.get("tran");
        String customerId=tran.getCustomerId();
        String customerName=(String)map.get("customerName");
        User user=(User) map.get("sessionUser");

        //如果需要创建客户
        if(customerId==null||customerId.trim().length()==0){
            Customer customer=new Customer();
            customer.setName(customerName);
            customer.setId(UUIDUtils.getUUID());
            customer.setOwner(user.getId());
            customer.setCreateTime(DateUtils.formatDateTime(new Date()));
            customer.setCreateBy(user.getId());

            int ret=customerMapper.insertCustomer(customer);

            //把customer的id设置到tran对象中
            tran.setCustomerId(customer.getId());
        }

        //保存交易
        tranMapper.insertTran(tran);

        //保存交易历史记录
        TranHistory tranHistory=new TranHistory();
        tranHistory.setCreateBy(user.getId());
        tranHistory.setCreateTime(DateUtils.formatDateTime(new Date()));
        tranHistory.setExpectedDate(tran.getExpectedDate());
        tranHistory.setId(UUIDUtils.getUUID());
        tranHistory.setMoney(tran.getMoney());
        tranHistory.setStage(tran.getStage());
        tranHistory.setTranId(tran.getId());
        tranHistoryMapper.insertTranHistory(tranHistory);

        return 0;
    }

    @Override
    public Tran queryTranForDetailById(String id) {
        return tranMapper.selectTranForDetailById(id);
    }

    @Override
    public List<FunnelVO> queryCountOfTranGroupByStage() {
        return tranMapper.selectCountOfTranGroupByStage();
    }

    @Override
    public List<TranVo> queryTranForPageByCondition(Map<String, Object> map) {
        return tranMapper.selectTranForPageByCondition(map);
    }

    @Override
    public long queryCountOfTranByCondition(Map<String, Object> map) {
        return tranMapper.selectCountofTran(map);
    }
}
