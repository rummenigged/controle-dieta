package br.com.DAO;

import java.util.List;

import br.com.entity.Alimento;

public interface AlimentoDAO{

	public Alimento create(Alimento alimento);
	
	public Alimento find(Integer id);
	
	public List<Alimento> findAll();
	
	public Alimento update(Alimento alimento);
	
	public Alimento delete(Integer id);
}
