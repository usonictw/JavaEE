package com.goit.ee.module2.dao;


import java.util.List;

public interface DAO<T> {
    boolean create(T t);
    boolean get(long id);
    boolean update(T t);
    boolean delete(long id);

}
