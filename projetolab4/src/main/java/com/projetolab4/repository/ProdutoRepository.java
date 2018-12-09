package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;


import com.projetolab4.model.Produto;

@Repository
public class ProdutoRepository implements JpaRepository<Produto, Long> {

	 @PersistenceUnit
	    private EntityManagerFactory emf;

	@Override
	public Produto save(Produto e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getForId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
		return null;
	}

	@Override
	public Produto findById(Long id) {
		EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        if(produto != null) {
            return produto;
        }
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Produto produto = findById(id);

        if(produto != null) {
            em.remove(em.contains(produto) ? produto:em.merge(produto));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
		return false;
	}

	@Override
	public void update(Produto e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getForId() != null) {
            em.merge(e);
        }
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<Produto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	 
	
}
