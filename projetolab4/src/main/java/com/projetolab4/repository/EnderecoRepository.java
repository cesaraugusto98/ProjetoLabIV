package com.projetolab4.repository;

import com.projetolab4.model.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@org.springframework.stereotype.Repository
public class EnderecoRepository {
// implements JpaRepository<Endereco, Long>
    
    @PersistenceUnit
    private EntityManagerFactory emf;

    public <S extends Endereco> S save(S s) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (s != null && s.getEndId() == null) {
            em.persist(s);
            em.getTransaction().commit();
            em.close();
            return s;
        }

        return null;
    }

    public Endereco findById(Long aLong) {
        EntityManager em = emf.createEntityManager();
        Endereco entity = em.find(Endereco.class, aLong);
        em.close();

        return entity;
    }

    public Boolean delete(Long id) {
        return true;
    }

    public Endereco update(Endereco entity) {
    	
        return entity;
    }

    public List<Endereco> getAll() {
        return null;
    }


}
