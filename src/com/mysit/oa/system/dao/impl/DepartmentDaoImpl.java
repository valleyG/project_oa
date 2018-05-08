package com.mysit.oa.system.dao.impl;

import com.mysit.oa.common.dao.BaseDaoImpl;
import com.mysit.oa.system.dao.DepartmentDao;
import com.mysit.oa.system.domain.Department;

import java.util.List;

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

    @Override
    public List<Department> findAllTopDepartment() {
        String hql = " where o.parent.id is NULL";
        return this.find(hql, null);
    }
}
