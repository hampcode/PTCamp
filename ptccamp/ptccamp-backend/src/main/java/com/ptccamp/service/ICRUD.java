package com.ptccamp.service;

import java.util.List;

public interface ICRUD<T>  {
	
	T insert(T obj);
	T update(T obj);
	List<T> getAll();
	T getById(Long id);
	void delete(Long id);

}
