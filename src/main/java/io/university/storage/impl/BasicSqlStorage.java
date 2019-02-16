package io.university.storage.impl;

import io.university.storage.IStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
abstract class BasicSqlStorage<T, ID extends Serializable>
        extends BasicStorageUtils<T, ID>
        implements IStorage<T, ID> {

    final Logger logger = LoggerFactory.getLogger(BasicSqlStorage.class);
    final JpaRepository<T, ID> repository;

    BasicSqlStorage(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public boolean exist(ID id) {
        try {
            return (isIdValid(id)) && repository.existsById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<T> find(ID id) {
        try {
            return (isIdValid(id)) ? repository.findById(id) : Optional.empty();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<T> save(T t) {
        try {
            return (isValid(t)) ? Optional.ofNullable(repository.save(t)) : Optional.empty();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<T> save(List<T> t) {
        try {
            return (isValid(t)) ? repository.saveAll(t) : Collections.emptyList();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean delete(T t) {
        if (isNotValid(t))
            return false;

        try {
            repository.delete(t);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean deleteById(ID id) {
        if (isIdNotValid(id))
            return false;

        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
