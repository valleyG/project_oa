package com.mysit.oa.system.service.impl;

import com.mysit.oa.system.dao.UserRoleDao;
import com.mysit.oa.system.domain.UserRole;
import com.mysit.oa.system.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService{
    private UserRoleDao userRoleDao;

    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public void addUserRole(UserRole userRole) {
        this.userRoleDao.save(userRole);
    }
}
