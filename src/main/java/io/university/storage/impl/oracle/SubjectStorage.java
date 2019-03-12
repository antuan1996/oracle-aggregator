package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.Subject;
import io.university.repository.oracle.SubjectRepository;
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
public class SubjectStorage extends BasicJpaStorage<Subject, Integer> {

    @Autowired
    public SubjectStorage(final SubjectRepository repository) {
        super(repository);
    }
}
