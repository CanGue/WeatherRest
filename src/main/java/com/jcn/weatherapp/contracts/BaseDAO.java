package com.jcn.weatherapp.contracts;

import java.util.Optional;

public interface BaseDAO<E,K> {
	
	public void create(E entity);
	public Optional<E> read(E entity,K id);
	public void update(E entity);
	public void delete(E entity);
	

}
