package com.goit.ee.module2.dao;

import java.util.List;

public interface DAO<T>{

    void create(T t);
    List<T> read(T t);
    void update(T t);
    void delete(T t);


}
