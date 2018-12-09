package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.projetolab4.model.Estoque;


@Repository
public class EstoqueRepository implements JpaRepository<Estoque, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

	@Override
	public Estoque save(Estoque e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getEstId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
        return null;
	}

	@Override
	public Estoque findById(Long id) {
		EntityManager em = emf.createEntityManager();
        Estoque estoque = em.find(Estoque.class, id);
        em.close();
        if(estoque != null) {
            return estoque;
        }
        return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estoque estoque = findById(id);

        if(estoque != null) {
            em.remove(em.contains(estoque) ? estoque:em.merge(estoque));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
	}

	@Override
	public Boolean update(Estoque e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getEstId() != null) {
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
	public List<Estoque> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
