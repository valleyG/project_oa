package com.mysit.oa.system.web.action;

import com.mysit.oa.common.web.action.BaseAction;
import com.mysit.oa.system.domain.Department;
import com.mysit.oa.system.domain.Role;
import com.mysit.oa.system.domain.User;
import com.mysit.oa.system.domain.UserRole;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserAction extends BaseAction<User> {
    //获取页面传上来的角色编号信息
    private Integer[] roleIdList;


    //获取页面传上来的部门编号
    private Integer departmentId;


    public Integer[] getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(Integer[] roleIdList) {
        this.roleIdList = roleIdList;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取用户列表
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        List<User> userList = this.userService.findAllUser();
        ActionContext.getContext().put("userList", userList);
        return "list";
    }

    /**
     * 跳转到添加用户界面
     * @return
     * @throws Exception
     */
    public String addUI() throws Exception {
        //TODO 获取到所有的顶层部门
        List<Department> allTopDepartment = this.departmentService.findAllTopDepartment();

        //TODO 获得部门树
        List<Department> departmentTree = this.departmentService.findDepartmentTree(allTopDepartment);

        //TODO 获取角色列表
        List<Role> roleList = this.roleService.findAll();


        //将部门树传回页面
        ActionContext.getContext().put("departmentTree", departmentTree);

        //将角色列表传回页面
        ActionContext.getContext().put("roleList", roleList);
        return "addUI";
    }

    /**
     * 添加用户
     * @return
     */
    public String add(){
        //或缺到页面传上来的一般用户信息
        User user = model;

        //TODO 根据页面传上来的部门编号查出部门
        Department department = this.departmentService.findDepartmentById(departmentId);
        //将部门信息加入到用户信息里面去
        user.setDepartment(department);

        //为用户添加默认初始化密码
        user.setPassword("123456");
        //先添加用户进去
        this.userService.addUser(user);
        //遍历角色列表，然后存入数据库
        for (Integer integer : roleIdList) {
            Role role = this.roleService.findRoleById(integer);
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            this.userRoleService.addUserRole(userRole);
        }

        return "add";
    }


    public String isExist() throws Exception{
        User user = model;
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        User queryUser = this.userService.findUserByLoginName(user.getLoginName());

        if (queryUser!=null){
            out.write("此登陆名已经存在了");
        }else {
            out.write("");
        }
        return null;
    }
}
