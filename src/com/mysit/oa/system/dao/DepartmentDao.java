package com.mysit.oa.system.dao;

import com.mysit.oa.common.dao.BaseDao;
import com.mysit.oa.system.domain.Department;

import java.util.List;

public interface DepartmentDao extends BaseDao<Department> {
    List<Department> findAllTopDepartment();


}
