package io.university.storage.impl;

import io.university.repository.DepartmentRepository;
import model.dao.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class DepartmentStorage extends BasicSqlStorage<Department, Integer> {

    @Autowired
    public DepartmentStorage(final DepartmentRepository repository) {
        super(repository);
    }
}
