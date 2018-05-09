package com.mysit.oa.system.domain;

import java.io.Serializable;

public class PrivilegeRole implements Serializable {

    private static final long serialVersionUID = -1544359492831773404L;
    private Integer id;
    private Role role;
    private Privilege privilege;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}
