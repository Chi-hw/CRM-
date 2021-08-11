package com.chw.chw.workbench.service;


import com.chw.chw.workbench.domain.ActivityRemark;

import java.util.List;

public interface ActivityRemarkService {


    List<ActivityRemark> queryActivityRemarkForDetailByActivityId(String id);

    int saveCreateActivityRemark(ActivityRemark remark);

    int deleteActivityRemarkById(String id);

    int saveEditActivityRemark(ActivityRemark remark);
}
