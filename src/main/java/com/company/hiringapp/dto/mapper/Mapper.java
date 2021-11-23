package com.company.hiringapp.dto.mapper;



import com.company.hiringapp.dto.AbstractDTO;
import com.company.hiringapp.entity.AbstractEntity;

import java.util.List;

public interface Mapper<E extends AbstractEntity, D extends AbstractDTO> {

    E toEntity(D d);

    D toDto(E e);

    List<D> toDtoList(List<E> eList);
}
