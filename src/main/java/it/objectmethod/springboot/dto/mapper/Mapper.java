package it.objectmethod.springboot.dto.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<E, D> {

	public List<E> toEntity(List<D> dtos) {
		List<E> entityList = new ArrayList<>();
		for (D dto : dtos) {
			entityList.add(toEntity(dto));
		}
		return entityList;
	}

	public List<D> toDto(List<E> entities) {
		List<D> dtoList = new ArrayList<>();
		for (E entity : entities) {
			dtoList.add(toDto(entity));
		}
		return dtoList;
	}

	public abstract E toEntity(D dto);

	public abstract D toDto(E entity);
}
