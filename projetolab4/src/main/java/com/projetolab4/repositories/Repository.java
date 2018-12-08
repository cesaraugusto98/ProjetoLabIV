package com.projetolab4.repositories;

import java.util.List;

public interface Repository<E, I> {
	I save(E entity);
	
	E findById(I id);
	
	long delete(I id);
	
	long update(E entity);
	
	List<E> getAll();
}
