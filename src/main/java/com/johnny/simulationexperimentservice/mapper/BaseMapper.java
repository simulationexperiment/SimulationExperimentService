package com.johnny.simulationexperimentservice.mapper;

import java.util.List;

public interface BaseMapper<T> {
    int searchTotalCount();

    List<T> searchList(int startIndex, int pageSize);

    T searchByID(int id);

    int existCheck(String value);

    int insert(T entity);

    int update(T entity);

    int delete(int id);
}
