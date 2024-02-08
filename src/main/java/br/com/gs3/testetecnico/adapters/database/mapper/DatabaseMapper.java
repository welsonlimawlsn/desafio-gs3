package br.com.gs3.testetecnico.adapters.database.mapper;

public interface DatabaseMapper<E, M> {

    E toEntity(M model);

    M toModel(E entity);
}
