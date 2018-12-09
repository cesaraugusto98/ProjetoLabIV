package com.projetolab4.repository;

import com.projetolab4.model.Funcionario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class FuncionarioRepository implements JpaRepository<Funcionario, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public Funcionario save(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (funcionario != null && funcionario.getFunId() == null) {
            em.persist(funcionario);
            em.getTransaction().commit();
            em.close();
            return funcionario;
        }
        return null;
    }

    @Override
    public Funcionario findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        if(funcionario != null) {
            return funcionario;
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = findById(id);

        if(funcionario != null) {
            em.remove(em.contains(funcionario) ? funcionario:em.merge(funcionario));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
    }

    @Override
    public Boolean update(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (funcionario != null && funcionario.getFunId() != null) {
            em.merge(funcionario);
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
    public List<Funcionario> getAll() {
        return null;
    }
}
