package com.mysit.oa.system.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {
    private static final long serialVersionUID = -9223126714218879541L;
    private Integer id;
    private String name;
    private String description;

    private Set<PrivilegeRole> privilegeRoles = new HashSet<>();

    public Set<PrivilegeRole> getPrivilegeRoles() {
        return privilegeRoles;
    }

    public void setPrivilegeRoles(Set<PrivilegeRole> privilegeRoles) {
        this.privilegeRoles = privilegeRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
