package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.projetolab4.model.Venda;

@Repository
public class VendaRepository implements JpaRepository<Venda, Long>  {

	@PersistenceUnit
    private EntityManagerFactory emf;
	
	@Override
	public Venda save(Venda e) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getVenId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
        return null;
	}

	@Override
	public Venda findById(Long id) {
		EntityManager em = emf.createEntityManager();
        Venda venda = em.find(Venda.class, id);
        em.close();
        if(venda != null) {
            return venda;
        }
        return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Venda venda = findById(id);

        if(venda != null) {
            em.remove(em.contains(venda) ? venda:em.merge(venda));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
	}

	@Override
	public void update(Venda e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getVenId() != null) {
            em.merge(e);
        }
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<Venda> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
