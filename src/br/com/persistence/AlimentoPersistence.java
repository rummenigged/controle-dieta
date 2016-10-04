package br.com.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.DAO.AlimentoDAO;
import br.com.entity.Alimento;

public class AlimentoPersistence implements AlimentoDAO{

	private EntityManagerFactory entityManagerFactory;
	private static final AlimentoPersistence instance = new AlimentoPersistence();
	
	public AlimentoPersistence(){
		entityManagerFactory = Persistence.createEntityManagerFactory("dieta-pu");
	}
	
	public static AlimentoPersistence getInstance(){
		return instance;
	}
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
	
	@Override
	public Alimento create(Alimento alimento) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(alimento);
		em.getTransaction().commit();
		
		return alimento;
	}

	@Override
	public Alimento find(Integer id) {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("select a from Alimento a where a.id = ?1", Alimento.class);
		q.setParameter(1, id);
		em.getTransaction().begin();
		Alimento alimento = (Alimento) q.getSingleResult();
		em.getTransaction().commit();
		
		return alimento;
	}

	@Override
	public List<Alimento> findAll() {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("select a from Alimento a", Alimento.class);
		em.getTransaction().begin();
		List alimentos = q.getResultList();
		em.getTransaction().commit();
		
		return alimentos;
	}

	@Override
	public Alimento update(Alimento alimento) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(alimento);
		em.getTransaction().commit();
		
		return alimento;
	}

	@Override
	public Alimento delete(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Alimento alimento = em.find(Alimento.class, id);
		em.remove(alimento);
		em.getTransaction().commit();
		
		return alimento;
	}

}
