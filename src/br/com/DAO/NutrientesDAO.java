package br.com.DAO;

import java.util.List;

import br.com.entity.Nutrientes;

public interface NutrientesDAO {

	public Nutrientes create(Nutrientes nutrientes);
	
	public Nutrientes find(Integer id);
	
	public List<Nutrientes> findAll();
	
	public Nutrientes update(Nutrientes nutrientes);
	
	public Nutrientes delete(Integer id);
}
