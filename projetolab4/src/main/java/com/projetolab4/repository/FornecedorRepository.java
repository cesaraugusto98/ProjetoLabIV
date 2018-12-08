package com.projetolab4.repository;

import com.projetolab4.model.Fornecedor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Repository
public class FornecedorRepository implements JpaRepository<Fornecedor, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public <S extends Fornecedor> S save(S s) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (s != null && s.getForId() == null && s.getEndereco() != null) {
            em.persist(s);
            em.getTransaction().commit();
            em.close();
            return s;
        }

        return null;
    }

    @Override
    public List<Fornecedor> findAll() {
        return null;
    }

    @Override
    public List<Fornecedor> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Fornecedor> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Fornecedor> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Fornecedor fornecedor) {

    }

    @Override
    public void deleteAll(Iterable<? extends Fornecedor> iterable) {

    }

    @Override
    public void deleteAll() {

    }



    @Override
    public <S extends Fornecedor> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Fornecedor> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Fornecedor> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Fornecedor> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Fornecedor getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Fornecedor> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Fornecedor> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Fornecedor> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Fornecedor> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Fornecedor> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Fornecedor> boolean exists(Example<S> example) {
        return false;
    }
}
