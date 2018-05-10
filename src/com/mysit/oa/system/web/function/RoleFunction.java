package com.mysit.oa.system.web.function;

import com.mysit.oa.system.domain.UserRole;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 自定义函数库
 */
public class RoleFunction {

    public static String showRoleName(Collection<UserRole> userRoles) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(userRoles)) {
            for (UserRole userRole : userRoles) {
                stringBuilder.append(userRole.getRole().getName()).append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        }
        return stringBuilder.toString();
    }
}
