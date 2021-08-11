package com.chw.chw.workbench.service.impl;

import com.chw.chw.workbench.domain.ClueRemark;
import com.chw.chw.workbench.mapper.ClueRemarkMapper;
import com.chw.chw.workbench.service.ClueRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ClueRemarkService")
public class ClueRemarkServiceImpl implements ClueRemarkService {
    @Autowired
    private ClueRemarkMapper clueRemarkMapper;
    @Override
    public List<ClueRemark> queryClueRemarkForDetailByClueId(String clueId) {
        return clueRemarkMapper.selectClueRemarkForDetailByClueId(clueId);
    }

    @Override
    public int saveCreateActivityRemark(ClueRemark remark) {
        return clueRemarkMapper.insertClueRemark(remark);
    }
}
