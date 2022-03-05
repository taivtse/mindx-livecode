package com.mindx.taivtse.livecode.mapper;

/**
 * @author taivt
 * @since 2022/03/05 20:09:38
 */
public interface EntityMapper<D, E> {
    E toEntity(D dto);

    D toDTO(E entity);
}
