package com.projetolab4.repository;

import com.projetolab4.model.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class EnderecoDao implements Dao<Endereco, Long> {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public Long save(Endereco newEndereco) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (newEndereco != null && newEndereco.getEndId() == null) {
            em.persist(newEndereco);
        }
        em.getTransaction().commit();
        em.close();

        return newEndereco.getEndId();
    }

    @Override
    public Endereco findById(Long id) {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public long update(Endereco entity) {
        return 0;
    }

    @Override
    public List<Endereco> getAll() {
        return null;
    }
}
