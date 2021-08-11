package com.chw.chw.workbench.service.impl;

import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.commons.utils.UUIDUtils;
import com.chw.chw.settings.domain.User;
import com.chw.chw.workbench.domain.*;
import com.chw.chw.workbench.mapper.*;
import com.chw.chw.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("clueService")
public class ClueServiceImpl implements ClueService {
    @Autowired
    private ClueMapper clueMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ContactsMapper contactsMapper;
    @Autowired
    private ClueRemarkMapper clueRemarkMapper;
    @Autowired
    private CustomerRemarkMapper customerRemarkMapper;
    @Autowired
    private ContactsRemarkMapper contactsRemarkMapper;
    @Autowired
    private ClueActivityRelationMapper clueActivityRelationMapper;
    @Autowired
    private ContactsActivityRelationMapper contactsActivityRelationMapper;
    @Autowired
    private TranMapper tranMapper;
    @Autowired TranRemarkMapper tranRemarkMapper;
    @Override
    public int saveCreateClue(Clue clue) {
        return clueMapper.insertClue(clue);
    }

    @Override
    public List<Clue> queryClueForPageByCondition(Map<String, Object> map) {
        return clueMapper.selectClueForPageByCondition(map);
    }

    @Override
    public long queryCountOfClueByCondition(Map<String, Object> map) {
        return clueMapper.selectCountOfClueByCondition(map);
    }

    @Override
    public Clue queryClueForDetailById(String id) {
        return clueMapper.selectClueForDetailById(id);
    }

    @Override
    public void saveConvert(Map<String, Object> map) {
        String clueId=(String)map.get("clueId");
        User user= (User)map.get("sessionUser");
        String isCreateTran=(String)map.get("isCreateTran");

        //根据clueId查询线索的信息
        Clue clue=clueMapper.selectClueById(clueId);
        //把该线索的公司的信息转换到客户表中
        Customer customer=new Customer();
        customer.setName(clue.getCompany());
        customer.setId(UUIDUtils.getUUID());
        customer.setAddress(clue.getAddress());
        customer.setContactSummary(clue.getContactSummary());
        customer.setCreateBy(user.getId());
        customer.setCreateTime(DateUtils.formatDateTime(new Date()));
        customer.setDescription(clue.getDescription());
        customer.setNextContactTime(clue.getNextContactTime());
        customer.setOwner(user.getId());
        customer.setPhone(clue.getPhone());
        customer.setWebsite(clue.getWebsite());
        customerMapper.insertCustomer(customer);

        //把该线索的个人的信息转换到联系人表中
        Contacts contacts=new Contacts();
        contacts.setAddress(clue.getAddress());
        contacts.setAppellation(clue.getAppellation());
        contacts.setContactSummary(clue.getContactSummary());
        contacts.setCreateBy(user.getId());
        contacts.setCreateTime(DateUtils.formatDateTime(new Date()));
        contacts.setCustomerId(customer.getId());
        contacts.setDescription(clue.getDescription());
        contacts.setEmail(clue.getEmail());
        contacts.setFullName(clue.getFullName());
        contacts.setJob(clue.getJob());
        contacts.setMphone(clue.getMphone());
        contacts.setId(UUIDUtils.getUUID());
        contacts.setNextContactTime(clue.getNextContactTime());
        contacts.setOwner(user.getId());
        contacts.setSource(clue.getSource());
        contactsMapper.insertContacts(contacts);

        //根据clueId查询该线索下所有的备注
        List<ClueRemark> clueRemarkList=clueRemarkMapper.selectClueRemarkByClueId(clueId);

        //遍历clueRemarkList，封装CustomerRemark，把该线索下所有的备注转换到客户备注表中一份
        //遍历clueRemarkList，封装ContactsRemark，把该线索下所有的备注转换到联系人备注表中一份
        if(clueRemarkList!=null&&clueRemarkList.size()>0){
            CustomerRemark cur=null;
            ContactsRemark cor=null;

            List<CustomerRemark> curList=new ArrayList<>();
            List<ContactsRemark> corList=new ArrayList<>();
            for(ClueRemark cr:clueRemarkList){
                cur=new CustomerRemark();
                cur.setCreateBy(cr.getCreateBy());
                cur.setCreateTime(cr.getCreateTime());
                cur.setCustomerId(customer.getId());
                cur.setEditBy(cr.getEditBy());
                cur.setEditFlag(cr.getEditFlag());
                cur.setEditTime(cr.getEditTime());
                cur.setId(UUIDUtils.getUUID());
                cur.setNoteContent(cr.getNoteContent());
                curList.add(cur);

                cor=new ContactsRemark();
                cor.setContactsId(contacts.getId());
                cor.setCreateBy(cr.getCreateBy());
                cor.setCreateTime(cr.getCreateTime());
                cor.setEditBy(cr.getEditBy());
                cor.setEditFlag(cr.getEditFlag());
                cor.setEditTime(cr.getEditTime());
                cor.setId(UUIDUtils.getUUID());
                cor.setNoteContent(cr.getNoteContent());
                corList.add(cor);
            }
            customerRemarkMapper.insertCustomerRemarkByList(curList);
            contactsRemarkMapper.insertContactsRemarkByList(corList);
        }

        //根据clueId查询线索和市场活动的关联关系
        List<ClueActivityRelation> carList=clueActivityRelationMapper.selectClueActivityRelationByClueId(clueId);
        //遍历carList，封装ContactsActivityRelation对象，把该线索和市场活动的关联关系转换到联系人和市场活动的关联关系表中
        if(carList!=null&&carList.size()>0){
            ContactsActivityRelation coar=null;
            List<ContactsActivityRelation> coarList=new ArrayList<>();
            for(ClueActivityRelation car:carList){
                coar=new ContactsActivityRelation();
                coar.setActivityId(car.getActivityId());
                coar.setContactsId(contacts.getId());
                coar.setId(UUIDUtils.getUUID());

                coarList.add(coar);
            }
            contactsActivityRelationMapper.insertContactsActivityRelationByList(coarList);
        }

        //如果需要创建交易，往交易表中添加一条记录
        if("true".equals(isCreateTran)){
            Tran tran=new Tran();
            tran.setActivityId((String)map.get("activityId"));
            tran.setContactsId(contacts.getId());
            tran.setCreateBy(user.getId());
            tran.setCreateTime(DateUtils.formatDateTime(new Date()));
            tran.setCustomerId(customer.getId());
            tran.setExpectedDate((String)map.get("expectedClosingDate"));
            tran.setId(UUIDUtils.getUUID());
            tran.setMoney((String)map.get("amountOfMoney"));
            tran.setName((String)map.get("tradeName"));
            tran.setOwner(user.getId());
            tran.setStage((String)map.get("stage"));
            tranMapper.insert(tran);

            //如果需要创建交易，还需要把该线索下所有的备注转换到交易备注表中一份
            //遍历clueRemarkList，封装TranRemark，把该线索下所有的备注转换到交易备注表中一份
            if(clueRemarkList!=null&&clueRemarkList.size()>0){
                TranRemark tr=null;
                List<TranRemark> trList=new ArrayList<>();
                for(ClueRemark cr:clueRemarkList){
                    tr=new TranRemark();
                    tr.setCreateBy(cr.getCreateBy());
                    tr.setCreateTime(cr.getCreateTime());
                    tr.setEditby(cr.getEditBy());
                    tr.setEditFlag(cr.getEditFlag());
                    tr.setEditTime(cr.getEditTime());
                    tr.setId(UUIDUtils.getUUID());
                    tr.setNoteContent(cr.getNoteContent());
                    tr.setTranId(tran.getId());
                    trList.add(tr);
                }
                tranRemarkMapper.insertTranRemarkByList(trList);
            }
        }

        //根据clueId删除该线索下所有的备注
        clueRemarkMapper.deleteClueRemarkByClueId(clueId);
        //根据clueId删除该线索和市场活动的关联关系
        clueActivityRelationMapper.deleteClueActivityRelationByClueId(clueId);
        //根据id删除该线索
        clueMapper.deleteClueById(clueId);
    }

}
