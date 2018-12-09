package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.projetolab4.model.ItemVenda;
import org.springframework.stereotype.Repository;

@Repository
public class ItemVendaRepository implements JpaRepository<ItemVenda, Long> {

    @PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public ItemVenda save(ItemVenda e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getItvId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
        return null;
	}

	@Override
	public ItemVenda findById(Long id) {
		EntityManager em = emf.createEntityManager();
        ItemVenda Itvd = em.find(ItemVenda.class, id);
        em.close();
        if(Itvd != null) {
            return Itvd;
        }
        return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ItemVenda itvd = findById(id);

        if(itvd  != null) {
            em.remove(em.contains(itvd ) ? itvd :em.merge(itvd ));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
	}

	@Override
	public Boolean update(ItemVenda e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getItvId() != null) {
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
	public List<ItemVenda> getAll() {
		return null;
	}

}
