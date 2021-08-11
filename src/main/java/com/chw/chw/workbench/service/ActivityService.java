package com.chw.chw.workbench.service;


import com.chw.chw.workbench.domain.Activity;
import com.chw.chw.workbench.domain.FunnelVO;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    int saveCreateActivity(Activity activity);


    List<Activity> queryActivityForPageByCondition(Map<String,Object> map);

    long queryCountOfActivityByCondition(Map<String,Object> map);

    Activity queryActivityById(String id);

    int saveEditActivity(Activity activity);

    int deleteActivityByIds(String[] id);

    List<Activity> queryAllActivityForDetail();

    List<Activity> queryActivityForDetailByIds(String[] id);

    int saveCreateActivityByList(List<Activity> activityList);


    Activity queryActivityForDetailById(String id);

    List<Activity> queryActivityForDetailByClueId(String id);

    List<Activity> queryActivityForDetailByNameClueId(Map<String, Object> map);

    List<Activity> queryActivityForDetailByName(String activityName);


    List<FunnelVO> queryCountOfActivity();
}
