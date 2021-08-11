package com.chw.chw.settings.service.impl;

import com.chw.chw.settings.domain.User;
import com.chw.chw.settings.mapper.UserMapper;
import com.chw.chw.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByLoginActandPwd(Map<String, Object> map) {
        return userMapper.selectUserByLoginActAndPwd(map);
    }

    @Override
    public List<User> getUser() {
        List<User> ulist=userMapper.selectUser();

        return ulist;
    }


}
