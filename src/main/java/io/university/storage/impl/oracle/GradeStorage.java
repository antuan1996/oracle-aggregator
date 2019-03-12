package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.Grade;
import io.university.repository.oracle.GradeRepository;
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
public class GradeStorage extends BasicJpaStorage<Grade, Integer> {

    @Autowired
    public GradeStorage(final GradeRepository repository) {
        super(repository);
    }
}
