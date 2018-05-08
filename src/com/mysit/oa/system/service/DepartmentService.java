package com.mysit.oa.system.service;

import com.mysit.oa.system.domain.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 查出所有的顶层部门
     * @return
     */
    List<Department> findAllTopDepartment();
}
