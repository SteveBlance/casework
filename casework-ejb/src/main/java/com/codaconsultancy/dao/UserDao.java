package com.codaconsultancy.dao;

import com.codaconsultancy.User;
import com.codaconsultancy.dao.common.Dao;

import javax.ejb.Local;

@Local
public interface UserDao extends Dao<User> {

    User findByUsername(String username);

}
