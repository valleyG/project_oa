package com.mysit.oa.system.service.impl;

import com.mysit.oa.system.dao.DepartmentDao;
import com.mysit.oa.system.domain.Department;
import com.mysit.oa.system.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> findAllTopDepartment() {
        List<Department> topDepartment = departmentDao.findAllTopDepartment();
        return topDepartment;
    }
}
