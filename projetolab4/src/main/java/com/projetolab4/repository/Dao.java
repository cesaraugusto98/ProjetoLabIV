package com.projetolab4.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface Dao<E, I> {
	E save(E entity);
	
	E findById(I id);
	
	void delete(I id);
	
	void update(E entity);
	
	List<E> getAll();
}
