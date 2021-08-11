package com.chw.chw.workbench.service.impl;

import com.chw.chw.workbench.domain.Activity;
import com.chw.chw.workbench.domain.FunnelVO;
import com.chw.chw.workbench.mapper.ActivityMapper;
import com.chw.chw.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int saveCreateActivity(Activity activity) {
        return activityMapper.insertActivity(activity);
    }

    @Override
    public List<Activity> queryActivityForPageByCondition(Map<String,Object> map) {
        return   activityMapper.selectActivityForPageByCondition(map);

    }

    @Override
    public long queryCountOfActivityByCondition(Map<String,Object> map) {
        return activityMapper.selectCountofActivity(map);
    }

    @Override
    public Activity queryActivityById(String id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveEditActivity(Activity activity) {
        return activityMapper.saveEditActivity(activity);
    }

    @Override
    public int deleteActivityByIds(String[] id) {
        return activityMapper.deleteActivityByIds(id);
    }

    @Override
    public List<Activity> queryAllActivityForDetail() {
        return activityMapper.selectAllActivityForDetail();
    }

    @Override
    public List<Activity> queryActivityForDetailByIds(String[] id) {
        return activityMapper.selectActivityForDetailByIds(id);
    }

    @Override
    public int saveCreateActivityByList(List<Activity> activityList) {
        return activityMapper.insertActivityByList(activityList);
    }

    @Override
    public Activity queryActivityForDetailById(String id) {
        return activityMapper.selectActivityForDetailById(id);
    }

    @Override
    public List<Activity> queryActivityForDetailByClueId(String clueId) {
        return activityMapper.selectActivityForDetailByClueId(clueId);
    }

    @Override
    public List<Activity> queryActivityForDetailByNameClueId(Map<String, Object> map) {
        return activityMapper.selectActivityForDetailByNameClueId(map);
    }

    @Override
    public List<Activity> queryActivityForDetailByName(String activityName) {
        return activityMapper.selectActivityForDetailByName(activityName);
    }

    @Override
    public List<FunnelVO> queryCountOfActivity() {
        return activityMapper.selectCountOfActivity();
    }


}
