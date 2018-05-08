package com.mysit.oa.common.web.action;

import com.mysit.oa.common.util.GenericUtil;
import com.mysit.oa.system.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    protected Class<T> clazz = GenericUtil.getGenericActualTypeParameterBySupperClass(this.getClass(), 0);
    protected T model;
    protected DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setModel(T model) {
        this.model = model;
    }


    @Override
    public T getModel() {
        if (this.model == null) {
            try {
                model = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return model;
    }
}
