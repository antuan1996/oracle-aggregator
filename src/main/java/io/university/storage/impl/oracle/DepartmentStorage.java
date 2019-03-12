package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.Department;
import io.university.repository.oracle.DepartmentRepository;
import io.university.storage.impl.BasicJpaStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class DepartmentStorage extends BasicJpaStorage<Department, Integer> {

    @Autowired
    public DepartmentStorage(final DepartmentRepository repository) {
        super(repository);
    }
}
