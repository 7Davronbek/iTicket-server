package com.example.iticket.common;

import java.util.List;

public interface CommonService<ID, ENTITY, UPDATE_ENTITY> {
    ENTITY findById(ID id);

    List<ENTITY> getAll();

    ENTITY update(ID id, UPDATE_ENTITY updateEntity);

    void delete(ID id);

    ENTITY add(ENTITY entity);
}
