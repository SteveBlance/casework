package com.codaconsultancy.casework.model.user.dao;

import com.codaconsultancy.casework.model.common.BaseDAO;
import com.codaconsultancy.casework.model.user.entity.User;

import javax.persistence.EntityManager;

public class UserDAO extends BaseDAO {

    public UserDAO() {
        super(User.class);
    }

    public UserDAO(EntityManager entityManager) {
        super(User.class, entityManager);
    }

    public User findByUsername(String username) {
        return null;
    }
}
