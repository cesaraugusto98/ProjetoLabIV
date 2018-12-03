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
    public Fornecedor save(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();

        return fornecedor;
    }

    @Override
    public Fornecedor findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Fornecedor entity = em.find(Fornecedor.class, id);
        em.close();

        return entity;
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        Fornecedor entity = em.find(Fornecedor.class, id);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();

        System.out.println("Removed fornecedor.");
    }

    @Override
    public void update(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        Fornecedor entity = em.find(Fornecedor.class, fornecedor.getForId());
        em.getTransaction().begin();

        entity.setForNomeFantasia(fornecedor.getForNomeFantasia());
        entity.setForContato(fornecedor.getForContato());
        entity.setForCnpj(fornecedor.getForCnpj());

        em.getTransaction().commit();
        em.close();

        System.out.println("Updated");
    }

    @Override
    public List<Fornecedor> getAll() {
        return null;
    }
}
