package com.mysit.oa.common.web.listener;

import com.mysit.oa.common.util.InitDataUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class initDataListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        if (!InitDataUtils.isInitRoleData()) {//判断role信息是否初始化，如果没有就初始化
            //初始化role角色信息
            InitDataUtils.initRoleData();
            //修改初始化状态信息
            InitDataUtils.modifyInitFlag();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
