package com.mysit.oa.system.service.impl;

import com.mysit.oa.system.dao.RoleDao;
import com.mysit.oa.system.domain.Role;
import com.mysit.oa.system.service.RoleService;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Role role) {
        if(role==null){
            throw new IllegalArgumentException("传入的角色对象为空");
        }
        roleDao.save(role);
    }
}
