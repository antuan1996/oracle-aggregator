package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.ODepartment;
import io.university.repository.oracle.ODepartmentRepository;
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
public class ODepartmentStorage extends BasicJpaStorage<ODepartment, Integer> {

    @Autowired
    public ODepartmentStorage(final ODepartmentRepository repository) {
        super(repository);
    }
}
