package com.chw.chw.workbench.service;

import com.chw.chw.workbench.domain.FunnelVO;
import com.chw.chw.workbench.domain.Tran;
import com.chw.chw.workbench.domain.TranVo;

import java.util.List;
import java.util.Map;

public interface TranService {
    int saveCreateTran(Map<String, Object> map);

    Tran queryTranForDetailById(String id);

    List<FunnelVO> queryCountOfTranGroupByStage();

    List<TranVo> queryTranForPageByCondition(Map<String, Object> map);

    long queryCountOfTranByCondition(Map<String, Object> map);
}
