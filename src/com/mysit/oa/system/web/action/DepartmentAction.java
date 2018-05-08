package com.mysit.oa.system.web.action;

import com.mysit.oa.common.web.action.BaseAction;
import com.mysit.oa.system.domain.Department;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class DepartmentAction extends BaseAction<Department> {
    private String flag;
    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String list() throws Exception {
        /**
         * 调用业务逻辑层
         */
        List<Department> allTopDepartment = this.departmentService.findAllTopDepartment();

        /**
         * 数据返回
         */
        ActionContext.getContext().put("allTopDepartment", allTopDepartment);
        return "list";
    }


    public String addUI() throws Exception {
        if (flag.equals("top")){
            ActionContext.getContext().put("flag", flag);
            return "addUI";
        }
        return null;
    }

    public String add() throws Exception {
        Department department = model;
        this.departmentService.addDepartment(department);
        return "add";
    }
}
