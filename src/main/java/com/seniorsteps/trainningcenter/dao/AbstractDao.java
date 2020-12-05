package com.seniorsteps.trainningcenter.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author SMARTCS
 */
public abstract class AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Criteria getCriteria() {
        Session session = getCurrentSession();
        return session.createCriteria(persistentClass);
    }

    public List<T> findAll() {
        Session session = getCurrentSession();
        Criteria criteria = session.createCriteria(persistentClass);
        return criteria.list();
    }

    public T findById(int id) {
        Session session = getCurrentSession();
        Criteria criteria = session.createCriteria(persistentClass);
        criteria.add(Restrictions.eq("id", id));
        return (T) criteria.uniqueResult();
    }

    public T save(T t) {
        Session session = getCurrentSession();
        session.persist(t);
        return t;
    }

    public T update(T t) {
        Session session = getCurrentSession();
        session.update(session.merge(t));
        return t;
    }

    public boolean delete(T t) {
        Session session = getCurrentSession();
        session.delete(t);
        return true;
    }
}
