package com.epam.vakhidat.news_management.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    void insert(T t);

    void update(T t);

    void delete(T t);

    T find(long id);
}
