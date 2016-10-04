package br.com.DAO;

import java.util.List;
import br.com.entity.Usuario;

public interface UsuarioDAO {

	public Usuario create(Usuario usuario);
	
	public Usuario find(Integer id);
	
	public List<Usuario> findAll();
	
	public Usuario update(Usuario usuario);
	
	public Usuario delete(Usuario usuario);
}
