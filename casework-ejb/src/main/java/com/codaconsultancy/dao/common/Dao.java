package com.codaconsultancy.dao.common;

import com.codaconsultancy.common.AbstractEntity;

import java.util.List;

public interface Dao<E extends AbstractEntity> {

    void persist(E instance);

    E find(long id);

    void remove(E instance);

    E merge(E instance);

    List<E> findAll();

}
