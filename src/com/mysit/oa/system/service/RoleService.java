package com.mysit.oa.system.service;

import com.mysit.oa.system.domain.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    List<Role> findAll();

    Role findRoleById(Integer integer);
}
