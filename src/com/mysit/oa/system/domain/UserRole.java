package com.mysit.oa.system.domain;

import java.io.Serializable;

public class UserRole implements Serializable {

    private static final long serialVersionUID = 4848810025532551646L;

    private Integer id;
    private User user;
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
