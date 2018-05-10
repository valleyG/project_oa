package com.mysit.oa.system.service.impl;

import com.mysit.oa.common.exception.OAException;
import com.mysit.oa.system.dao.DepartmentDao;
import com.mysit.oa.system.domain.Department;
import com.mysit.oa.system.service.DepartmentService;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

    @Override
    public List<Department> findDepartmentTree(List<Department> allTopDepartment) {
        List<Department> departmentTree = new ArrayList<>();
        departmentTree = recursionGenerateDepartmentTree(allTopDepartment,departmentTree,"|---");
        return departmentTree;
    }


    /**
     * 递归生成部门事树
     * @param allTopDepartment
     * @param departmentTree
     * @param prefix
     * @return
     */
    private List<Department> recursionGenerateDepartmentTree(List<Department> allTopDepartment, List<Department> departmentTree, String prefix) {
        for (Department department : allTopDepartment) {
            Department newDepartment = new Department();
            newDepartment.setId(department.getId());
            newDepartment.setName(prefix+department.getName());
            newDepartment.setDescription(department.getDescription());
            departmentTree.add(newDepartment);
            if (!CollectionUtils.isEmpty(department.getChildren())){
                recursionGenerateDepartmentTree(new ArrayList<>(department.getChildren()), departmentTree, "--"+prefix);
            }
        }

        return departmentTree;
    }
}
