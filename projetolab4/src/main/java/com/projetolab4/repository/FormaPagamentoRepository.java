package com.projetolab4.repository;

import com.projetolab4.model.FormaPagamento;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class FormaPagamentoRepository implements JpaRepository<FormaPagamento, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public FormaPagamento save(FormaPagamento formaPagamento) {
        return null;
    }

    @Override
    public FormaPagamento findById(Long id) {
        EntityManager em = emf.createEntityManager();
        FormaPagamento formaPagamento = em.find(FormaPagamento.class, id);
        em.close();
        if(formaPagamento != null) {
            return formaPagamento;
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public void update(FormaPagamento formaPagamento) {

    }

    @Override
    public List<FormaPagamento> getAll() {
        return null;
    }
}
