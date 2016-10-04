package br.com.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.DAO.UsuarioDAO;
import br.com.entity.Usuario;

public class UsuarioPersistence implements UsuarioDAO{
	
	private EntityManagerFactory entityManagerFactory;
	private static final UsuarioPersistence instance = new UsuarioPersistence(); 

	public UsuarioPersistence(){
		entityManagerFactory = Persistence.createEntityManagerFactory("dieta-pu");
	}
	
	public static UsuarioPersistence getInstance(){
		return instance;
	}
	
	public EntityManager getEntityManeger(){
		return entityManagerFactory.createEntityManager();
	}
	
	@Override
	public Usuario create(Usuario usuario) {
		EntityManager em = getEntityManeger();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		return usuario;
	}

	@Override
	public Usuario find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario delete(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
