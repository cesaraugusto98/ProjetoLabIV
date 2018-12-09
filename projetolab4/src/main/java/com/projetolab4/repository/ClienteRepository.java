package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.projetolab4.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements JpaRepository<Cliente, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

	@Override
	public Cliente save(Cliente e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getCliId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
        return null;
	}

	@Override
	public Cliente findById(Long id) {
		EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        if(cliente != null) {
            return cliente;
        }
        return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = findById(id);

        if(cliente != null) {
            em.remove(em.contains(cliente) ? cliente:em.merge(cliente));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
	}

	@Override
	public Boolean update(Cliente e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getCliId() != null) {
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
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
