package br.com.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.DAO.NutrientesDAO;
import br.com.entity.Alimento;
import br.com.entity.Nutrientes;

public class NutrientesPersistence implements NutrientesDAO{

	private EntityManagerFactory entityManagerFactory;
	private static final NutrientesPersistence instance = new NutrientesPersistence();
	
	public NutrientesPersistence() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dieta-pu");
	}
	
	public static NutrientesPersistence getInstance(){
		return instance;
	}
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public Nutrientes create(Nutrientes nutrientes) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(nutrientes);
		em.getTransaction().commit();
		
		return nutrientes;
	}

	@Override
	public Nutrientes find(Integer id) {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("selecr n from Nutrientes n where n.id = ?1", Nutrientes.class);
		q.setParameter(1, id);
		em.getTransaction().begin();
		Nutrientes nutrientes = (Nutrientes) q.getSingleResult();
		em.getTransaction().commit();
		
		return nutrientes;
	}

	@Override
	public List<Nutrientes> findAll() {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("select n from Nutrientes n", Nutrientes.class);
		em.getTransaction().begin();
		List<Nutrientes> nutrientes = q.getResultList();
		em.getTransaction().commit();
		
		return nutrientes;
	}

	@Override
	public Nutrientes update(Nutrientes nutrientes) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(nutrientes);
		em.getTransaction().commit();
		
		return nutrientes;
	}

	@Override
	public Nutrientes delete(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Nutrientes nutrientes = em.find(Nutrientes.class, id);
		em.remove(nutrientes);
		em.getTransaction().commit();
		
		return nutrientes;
	}
	

}
