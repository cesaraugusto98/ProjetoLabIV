package com.projetolab4.repository;

import com.projetolab4.model.Fornecedor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class FornecedorRepository implements JpaRepository<Fornecedor, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (fornecedor != null && fornecedor.getForId() == null) {
            em.persist(fornecedor);
            em.getTransaction().commit();
            em.close();
            return fornecedor;
        }
        return null;
    }

    @Override
    public Fornecedor findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        em.close();
        if(fornecedor != null) {
            return fornecedor;
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fornecedor fornecedor = findById(id);

        if(fornecedor != null) {
            em.remove(em.contains(fornecedor) ? fornecedor:em.merge(fornecedor));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
    }

    @Override
    public Boolean update(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (fornecedor != null && fornecedor.getForId() != null) {
            em.merge(fornecedor);
        }
        
        try {
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    @Override
    public List<Fornecedor> getAll() {
        return null;
    }
}
