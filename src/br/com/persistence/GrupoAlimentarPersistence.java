package br.com.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import br.com.DAO.GrupoAlimentarDAO;
import br.com.entity.GrupoAlimentar;

public class GrupoAlimentarPersistence implements GrupoAlimentarDAO{

	private EntityManagerFactory entityManagerFactory;
	private static final GrupoAlimentarPersistence instance = new GrupoAlimentarPersistence();
	
	public GrupoAlimentarPersistence(){
		entityManagerFactory = Persistence.createEntityManagerFactory("dieta-pu");
	}
	
	public static GrupoAlimentarPersistence getInstance(){
		return instance;
	}
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public GrupoAlimentar create(GrupoAlimentar grupoAlimentar) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(grupoAlimentar);
		em.getTransaction().commit();
		
		return grupoAlimentar;
	}

	@Override
	public GrupoAlimentar find(Integer id) {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("select g from GrupoAlimentar g where g.id = ?1", GrupoAlimentar.class);
		q.setParameter(1, id);
		em.getTransaction().begin();
		GrupoAlimentar grupoAlimentar =(GrupoAlimentar) q.getSingleResult();
		em.getTransaction().commit();
		
		return grupoAlimentar;
	}

	@Override
	public List<GrupoAlimentar> findAll() {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("select g from GrupoAlimentar g", GrupoAlimentar.class);
		em.getTransaction().begin();
		List<GrupoAlimentar> grupos = q.getResultList();
		em.getTransaction().commit();
		
		return grupos;
	}

	@Override
	public GrupoAlimentar update(GrupoAlimentar grupoAlimentar) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(grupoAlimentar);
		em.getTransaction().commit();
		
		return grupoAlimentar;
	}

	@Override
	public GrupoAlimentar delete(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		GrupoAlimentar grupoAlimentar = em.find(GrupoAlimentar.class, id);
		em.getTransaction().commit();
		
		return grupoAlimentar;
	}

	
	
}
