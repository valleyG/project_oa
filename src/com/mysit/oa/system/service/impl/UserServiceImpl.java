package com.mysit.oa.system.service.impl;

import com.mysit.oa.system.dao.UserDao;
import com.mysit.oa.system.domain.User;
import com.mysit.oa.system.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllUser() {
        List<User> userList = this.userDao.findAll();
        return userList;
    }

    @Override
    public void addUser(User user) {
        this.userDao.save(user);
    }

    @Override
    public User findUserByLoginName(String loginName) {
        String whereHql = "where o.loginName is '"+loginName+"'";
        List<User> userList = this.userDao.find(whereHql, null);
        if (userList.size()==0){
            return null;
        }
        return userList.get(0);
    }
}
