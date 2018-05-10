package com.mysit.oa.system.service;

import com.mysit.oa.system.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    void addUser(User user);

    User findUserByLoginName(String loginName);
}
