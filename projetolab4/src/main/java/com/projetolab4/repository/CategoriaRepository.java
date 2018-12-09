package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.projetolab4.model.Categoria;
import com.projetolab4.model.Fornecedor;

@Repository
public class CategoriaRepository implements JpaRepository<Categoria, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

	@Override
	public Categoria save(Categoria e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getCatId() == null) {
            em.persist(e);
            em.getTransaction().commit();
            em.close();
            return e;
        }
        return null;
	}

	@Override
	public Categoria findById(Long id) {
		EntityManager em = emf.createEntityManager();
        Categoria categoria = em.find(Categoria.class, id);
        em.close();
        if(categoria  != null) {
            return categoria ;
        }
        return null;
	}

	@Override
	public Boolean delete(Long id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Categoria  categoria = findById(id);

        if(categoria  != null) {
            em.remove(em.contains(categoria ) ? categoria :em.merge(categoria ));
            em.getTransaction().commit();
            em.close();

            return true;
        }
        em.close();
        return false;
	}

	@Override
	public void update(Categoria e) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (e != null && e.getCatId() != null) {
            em.merge(e);
        }
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
