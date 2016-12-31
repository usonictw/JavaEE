package com.goit.ee.module3.dao;

public interface DAO<T> {
    void create(T t);
    T get(long id);
    void update(T t, long id);
    void delete(long id);

}
