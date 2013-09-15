package com.codaconsultancy.casework.model.user.dao;

import com.codaconsultancy.casework.model.common.BaseDAO;
import com.codaconsultancy.casework.model.user.entity.User;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Named
public class UserDAO extends BaseDAO<User> {

    public static final String FIND_USER_BY_USERNAME = "from User u where u.username = :username";

    public UserDAO() {
        super(User.class);
    }

    public UserDAO(EntityManager entityManager) {
        super(User.class, entityManager);
    }

    public User findByUsername(String username) {
        Query query = entityManager.createQuery(FIND_USER_BY_USERNAME);
        query.setParameter(":username", username);
        return (User) query.getSingleResult();
    }

}
