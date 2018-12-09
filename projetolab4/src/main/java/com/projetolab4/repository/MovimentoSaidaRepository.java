package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.projetolab4.model.MovimentoSaida;

@Repository
public class MovimentoSaidaRepository implements JpaRepository<MovimentoSaida, Long> {

	 @PersistenceUnit
	 private EntityManagerFactory emf;
	
	@Override
	public MovimentoSaida save(MovimentoSaida e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getMesId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
        return null;
	}

	@Override
	public MovimentoSaida findById(Long id) {
		EntityManager em = emf.createEntityManager();
        MovimentoSaida mvSaida = em.find(MovimentoSaida.class, id);
        em.close();
        if(mvSaida != null) {
            return mvSaida;
        }
        return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MovimentoSaida mvSaida = findById(id);

        if(mvSaida != null) {
            em.remove(em.contains(mvSaida) ? mvSaida:em.merge(mvSaida));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
	}

	@Override
	public void update(MovimentoSaida e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getMesId() != null) {
            em.merge(e);
        }
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<MovimentoSaida> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
