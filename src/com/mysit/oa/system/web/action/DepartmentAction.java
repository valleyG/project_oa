package com.mysit.oa.system.web.action;

import com.mysit.oa.common.web.action.BaseAction;
import com.mysit.oa.system.domain.Department;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class DepartmentAction extends BaseAction<Department> {

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
}
