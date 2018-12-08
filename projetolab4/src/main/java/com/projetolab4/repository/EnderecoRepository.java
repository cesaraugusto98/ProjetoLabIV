package com.projetolab4.repository;

import com.projetolab4.model.Endereco;
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
public class EnderecoRepository implements JpaRepository<Endereco, Long> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
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

    @Override
    public List<Endereco> findAll() {
        return null;
    }

    @Override
    public List<Endereco> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Endereco> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Endereco> findAllById(Iterable<Long> iterable) {
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
    public void delete(Endereco endereco) {

    }

    @Override
    public void deleteAll(Iterable<? extends Endereco> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Endereco> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Endereco> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Endereco entity = em.find(Endereco.class, id);
        em.close();

        return Optional.of(entity);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Endereco> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Endereco> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Endereco getOne(Long aLong) {
        EntityManager em = emf.createEntityManager();
        Endereco entity = em.find(Endereco.class, aLong);
        em.close();

        return entity;
    }

    @Override
    public <S extends Endereco> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Endereco> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Endereco> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Endereco> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Endereco> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Endereco> boolean exists(Example<S> example) {
        return false;
    }
}
