package com.projetolab4.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface Dao<E, I> {
	I save(E entity);
	
	E findById(I id);
	
	long delete(I id);
	
	long update(E entity);
	
	List<E> getAll();
}
