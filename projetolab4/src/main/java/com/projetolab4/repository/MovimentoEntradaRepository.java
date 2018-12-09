package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.projetolab4.model.MovimentoEntrada;

@Repository
public class MovimentoEntradaRepository implements JpaRepository<MovimentoEntrada, Long>{

	@PersistenceUnit
    private EntityManagerFactory emf;
	
	@Override
	public MovimentoEntrada save(MovimentoEntrada e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getMetId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
        return null;
	}

	@Override
	public MovimentoEntrada findById(Long id) {
		 EntityManager em = emf.createEntityManager();
	        MovimentoEntrada movEntrada = em.find(MovimentoEntrada.class, id);
	        em.close();
	        if(movEntrada != null) {
	            return movEntrada;
	        }
	        return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MovimentoEntrada movEntrada = findById(id);

        if(movEntrada != null) {
            em.remove(em.contains(movEntrada) ? movEntrada:em.merge(movEntrada));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
	}

	@Override
	public Boolean update(MovimentoEntrada e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getMetId() != null) {
            em.merge(e);
        }
        
        
        try {
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e2) {
			return false;
		}
		
	}

	@Override
	public List<MovimentoEntrada> getAll() {
		return null;
	}

}
