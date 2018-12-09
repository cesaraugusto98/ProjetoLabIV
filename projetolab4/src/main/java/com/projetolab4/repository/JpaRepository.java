package com.projetolab4.repository;

import java.util.List;

public interface JpaRepository<E, L> {
	E save(E e);
	
	E findById(L id);
	
	Boolean delete(L id);
	
	Boolean update(E e);
	
	List<E> getAll();
}
