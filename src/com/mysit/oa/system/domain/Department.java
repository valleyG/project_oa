package com.mysit.oa.system.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable {

    private static final long serialVersionUID = -5868704267939693610L;

    private Integer id;
    private String name;
    private String description;

    /**
     * @many-to-one
     */
    private Department parent;

    /**
     * @one-to-many
     */
    private Set<Department> children = new HashSet<>();


    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Set<Department> getChildren() {
        return children;
    }

    public void setChildren(Set<Department> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
