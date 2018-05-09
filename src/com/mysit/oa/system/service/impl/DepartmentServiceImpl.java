package com.mysit.oa.system.service.impl;

import com.mysit.oa.common.exception.OAException;
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

    @Override
    public void addDepartment(Department department) {
        departmentDao.save(department);
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        if (id==null||id<=0){
            throw new OAException("传入的部门ID有错误");
        }
        Department department = this.findDepartmentById(id);
        if (department.getUsers()!=null&&department.getUsers().size()>0){
            throw new OAException("该部门下面有员工,不能删除");
        }else {
            //删除部门
            this.departmentDao.delete(department);
        }
    }

    @Override
    public Department findDepartmentById(Integer id) {
        if (id==null||id<=0){
            throw new OAException("查询部门的时候传入的部门编号不合法");
        }


        return this.departmentDao.findById(id);

    }
}
