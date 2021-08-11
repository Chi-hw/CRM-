package com.chw.chw.settings.service;

import com.chw.chw.settings.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService{

    User queryUserByLoginActandPwd(Map<String, Object> map);

    List<User> getUser();
}
