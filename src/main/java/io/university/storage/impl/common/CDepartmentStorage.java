package io.university.storage.impl.common;

import io.university.model.dao.common.CDepartment;
import io.university.repository.common.CDepartmentRepository;
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
public class CDepartmentStorage extends BasicJpaStorage<CDepartment, Integer> {

    @Autowired
    public CDepartmentStorage(final CDepartmentRepository repository) {
        super(repository);
    }
}
