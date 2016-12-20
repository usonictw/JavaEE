package com.goit.ee.module2.dao;

public interface DAO<T> {
    void create(T t);
    T get(long id);
    void update(T t);
    void delete(long id);

}
