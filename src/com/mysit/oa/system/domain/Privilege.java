package com.mysit.oa.system.domain;

import java.io.Serializable;
import java.util.Set;

public class Privilege implements Serializable {

    private static final long serialVersionUID = -731867231403081246L;

    private Integer id;
    private String name;
    private String url;
    private Privilege parent;
    private Set<Privilege> children;

    //层次问题
    private Integer level;

    //是否为叶子节点
    private String isLeaf;

    //是否是模块  Y表示模块，N表示操作
    private String isModule;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Privilege getParent() {
        return parent;
    }

    public void setParent(Privilege parent) {
        this.parent = parent;
    }

    public Set<Privilege> getChildren() {
        return children;
    }

    public void setChildren(Set<Privilege> children) {
        this.children = children;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getIsModule() {
        return isModule;
    }

    public void setIsModule(String isModule) {
        this.isModule = isModule;
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

}
