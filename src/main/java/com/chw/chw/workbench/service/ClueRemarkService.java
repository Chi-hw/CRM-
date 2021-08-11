package com.chw.chw.workbench.service;

import com.chw.chw.workbench.domain.ClueRemark;

import java.util.List;

public interface ClueRemarkService {
    List<ClueRemark> queryClueRemarkForDetailByClueId(String id);

    int saveCreateActivityRemark(ClueRemark remark);
}
