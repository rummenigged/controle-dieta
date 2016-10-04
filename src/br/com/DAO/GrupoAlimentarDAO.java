package br.com.DAO;

import java.util.List;
import br.com.entity.GrupoAlimentar;

public interface GrupoAlimentarDAO {
	
	public GrupoAlimentar create(GrupoAlimentar grupoAlimentar);
	
	public GrupoAlimentar find(Integer id);
	
	public List<GrupoAlimentar> findAll();
	
	public GrupoAlimentar update(GrupoAlimentar grupoAlimentar);
	
	public GrupoAlimentar delete(Integer id);
}
