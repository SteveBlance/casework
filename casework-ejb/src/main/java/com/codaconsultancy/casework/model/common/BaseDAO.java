package com.codaconsultancy.casework.model.common;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class BaseDAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityClass;

    public BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public BaseDAO(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    public List findAll() {
        final StringBuilder queryString = new StringBuilder(
                "SELECT o from ");
        queryString.append(entityClass.getSimpleName()).append(" o ");

        final Query query = entityManager.createQuery(queryString.toString());
        return query.getResultList();
    }

    public long countAll() {
        final StringBuilder queryString = new StringBuilder(
                "SELECT count(o) from ");

        queryString.append(entityClass.getSimpleName()).append(" o ");

        final Query query = entityManager.createQuery(queryString.toString());

        return (Long) query.getSingleResult();
    }

    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void delete(final T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    public T findById(final Object id) {
        T result = (T) entityManager.find(entityClass, id);

        if (result == null) {
            throw new NoResultException("No Results found for " +
                    entityClass.getName() + " with id " + id);
        }

        return result;
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }
}
