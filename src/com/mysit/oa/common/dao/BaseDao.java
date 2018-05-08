package com.mysit.oa.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    void save(T t);

    void delete(T t);

    void update(T t);

    T findById(Serializable id);

    List<T> findAll();

    <P> List<T> find(String whereHql, P... params);
}
