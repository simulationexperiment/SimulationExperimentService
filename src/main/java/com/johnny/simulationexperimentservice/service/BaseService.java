package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface BaseService<T, V, E> {
    UnifiedResponse findList(int pageNumber, int pageSize);

    UnifiedResponse find(int id);

    UnifiedResponse existCheck(String value);

    UnifiedResponse add(T dto);

    UnifiedResponse change(T dto);

    UnifiedResponse delete(T dto);
}
