package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.projetolab4.model.Cliente;
import com.projetolab4.model.Funcionario;


@Repository
public class ClienteDao implements Dao<Cliente, Long> {
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	@Override
	public Cliente save(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		
		return cliente;
	}
	
	
	@Override
	public long delete(Long id) {
		EntityManager em = emf.createEntityManager();
		Cliente entity = em.find(Cliente.class, id);
		em.getTransaction().begin();
        em.remove(entity);
       try {
    	   em.getTransaction().commit();
           em.close();
   		   System.out.println("Removed cliente.");
           return 1;
	} catch (Exception e) {
		System.out.println("Removed cliente.");
		return 0;
	}
	
	

}
	
	@Override
	public long update(Cliente cliente) {
		 EntityManager em = emf.createEntityManager();
	        Cliente entity = em.find(Cliente.class, cliente.getCliId());
	        em.getTransaction().begin();
	        entity.setCliContato(cliente.getCliContato());
	        entity.setCliCpf(cliente.getCliCpf());
	        entity.setCliNome(cliente.getCliNome());
	        
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
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
