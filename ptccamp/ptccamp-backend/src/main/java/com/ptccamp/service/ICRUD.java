package com.ptccamp.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T>  {
	
	T insert(T obj);
	T update(T obj);
	List<T> getAll();
	Optional<T> getById(Long id);
	void delete(Long id);

}
