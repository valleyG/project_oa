package com.mysit.oa.system.service.impl;

import com.mysit.oa.system.dao.RoleDao;
import com.mysit.oa.system.domain.Role;
import com.mysit.oa.system.service.RoleService;

import java.util.List;

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

    @Override
    public List<Role> findAll() {

        return this.roleDao.findAll();

    }

    @Override
    public Role findRoleById(Integer integer) {
        return this.roleDao.findById(integer);
    }
}
