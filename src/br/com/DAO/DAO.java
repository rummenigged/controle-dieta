package br.com.DAO;

import java.util.List;

public interface DAO<O> {

	public O create(O objeto);
	
	public O find(Integer id);
	
	public List<O> findAll();
	
	public O update(O objeto);
	
	public O delete(O objeto);
}
