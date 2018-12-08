package com.projetolab4.repository;

import com.projetolab4.model.Fornecedor;
import com.projetolab4.model.Funcionario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class FornecedorDao implements Dao<Fornecedor, Long> {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public Long save(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();

        return fornecedor.getForId();
    }

    @Override
    public Fornecedor findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Fornecedor entity = em.find(Fornecedor.class, id);
        em.close();

        return entity;
    }

    @Override
    public long delete(Long id) {
        EntityManager em = emf.createEntityManager();
        Fornecedor entity = em.find(Fornecedor.class, id);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();

        System.out.println("Removed fornecedor.");
        
        return 1;
    }

    @Override
    public long update(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        Fornecedor entity = em.find(Fornecedor.class, fornecedor.getForId());
        em.getTransaction().begin();

        entity.setForNomeFantasia(fornecedor.getForNomeFantasia());
        entity.setForContato(fornecedor.getForContato());
        entity.setForCnpj(fornecedor.getForCnpj());

        
        try {
        	em.getTransaction().commit();
        	System.out.println("Updated");
        	em.close();
        	return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 2;
			
		}
        

        
        
    }

    @Override
    public List<Fornecedor> getAll() {
        return null;
    }
}
