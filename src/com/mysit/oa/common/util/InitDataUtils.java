package com.mysit.oa.common.util;

import com.mysit.oa.system.domain.Role;
import com.mysit.oa.system.service.RoleService;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Properties;

public class InitDataUtils {

    private static RoleService roleService;

    public void setRoleService(RoleService roleService) {
        InitDataUtils.roleService = roleService;
    }

    public static void initRoleData(){
        String name = null;
        String description = null;

        Document initDate = Dom4jUtiles.getDocument("initData.xml");
        List<Element> roleElementList = initDate.selectNodes("//inite-data/roles/role");
        for (Element element : roleElementList) {
            Role role = new Role();
            name= element.elementText("name");
            description=element.elementText("description");
            role.setName(name);
            role.setDescription(description);
            roleService.addRole(role);
        }
    }

    public static boolean isInitRoleData(){
        Properties properties = new Properties();
        try {
            properties.load(InitDataUtils.class.getClassLoader().getResourceAsStream("init-flag.properties"));
            String flag = properties.getProperty("flag");
            if ("true".equals(flag)){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void modifyInitFlag(){
        Properties properties = new Properties();
        try{
            properties.load(InitDataUtils.class.getClassLoader().getResourceAsStream("init-flag.properties"));
            properties.setProperty("flag", "true");

            URL flagUrl = InitDataUtils.class.getClassLoader().getResource("init-flag.properties");
            String path = URLEncoder.encode(flagUrl.getPath(), "utf-8");
            properties.store(new FileOutputStream(path), "修改安装状态");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
