package com.projetolab4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.projetolab4.model.Fornecedor;
import com.projetolab4.model.Funcionario;

@Repository
public class FuncionarioDao implements Dao<Funcionario, Long>{
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	@Override
	public Long save(Funcionario funcionario) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
		
		return funcionario.getFunId();
		
	}
	
	
	@Override
	public Funcionario findById(Long id) {
		EntityManager em = emf.createEntityManager();
		Funcionario entity = em.find(Funcionario.class, id);
		em.close();
		
		return entity;
	}
	@Override
	public long delete(Long id) {
		 EntityManager em = emf.createEntityManager();
	        Funcionario entity = em.find(Funcionario.class, id);
	        em.getTransaction().begin();
	        em.remove(entity);
	        em.getTransaction().commit();
	        em.close();

	        System.out.println("Removed funcioanrio.");
	        
	        return 1;
	    }
	
	
	@Override
	public long update(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        Funcionario entity = em.find(Funcionario.class, funcionario.getEndId());
        em.getTransaction().begin();

        entity.setFunCargo(funcionario.getFunCargo());
        entity.setFunContato(funcionario.getFunContato());
        entity.setFunCpf(funcionario.getFunCpf());
        entity.setFunLogin(funcionario.getFunLogin());
        entity.setFunNome(funcionario.getFunNome());
        entity.setFunSalario(funcionario.getFunSalario());
        entity.setFunSenha(funcionario.getFunSenha());
       
        
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
	public List<Funcionario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
