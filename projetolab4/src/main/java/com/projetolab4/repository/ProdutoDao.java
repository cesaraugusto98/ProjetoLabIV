package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.projetolab4.model.Produto;

public class ProdutoDao implements Dao<Produto, Long>{
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public Produto save(Produto produto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		
		return produto;
	}

	@Override
	public Produto findById(Long id) {
		EntityManager em = emf.createEntityManager();
        Produto entity = em.find(Produto.class, id);
        em.close();

        return entity;
		
	}

	@Override
	public long delete(Long id) {
		EntityManager em = emf.createEntityManager();
        Produto entity = em.find(Produto.class, id);
        em.getTransaction().begin();
        em.remove(entity);
        try {
        	em.getTransaction().commit();
            em.close();
            System.out.println("Removed produto.");
            return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}

	@Override
	public long update(Produto produto) {
		EntityManager em = emf.createEntityManager();
        Produto entity = em.find(Produto.class, produto.getForId());
        em.getTransaction().begin();
        
        entity.setProCusto(produto.getProCusto());
        entity.setProNome(produto.getProNome());
        entity.setProPreco(produto.getProPreco());
        
        try {
        	em.getTransaction().commit();
            em.close();
            System.out.println("Updated");
            return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
        
        

		
	}

	@Override
	public List<Produto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
