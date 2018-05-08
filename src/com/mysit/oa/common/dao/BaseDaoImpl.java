package com.mysit.oa.common.dao;

import com.mysit.oa.common.util.GenericUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    private HibernateTemplate hibernateTemplate;
    //类参数的实际类型
    protected Class<T> entityClass = GenericUtil.getGenericActualTypeParameterBySupperClass(this.getClass(), 0);
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(T t) {
        this.hibernateTemplate.persist(t);
    }

    @Override
    public void delete(T t) {
        this.hibernateTemplate.delete(t);
    }

    @Override
    public void update(T t) {
        this.hibernateTemplate.update(t);
    }

    @Override
    public T findById(Serializable id) {
        return this.hibernateTemplate.load(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        String hql = " from "+entityClass.getSimpleName();
        return (List<T>) this.hibernateTemplate.find(hql, null);
    }

    @Override
    public <P> List<T> find(String whereHql, P... params) {
        StringBuffer hql = new StringBuffer(" from " +this.entityClass.getSimpleName()+" o ");
        if (StringUtils.isBlank(whereHql)) {
            hql.append(whereHql);
        }

        return (List<T>) this.hibernateTemplate.find(hql.toString(),params);
    }
}
