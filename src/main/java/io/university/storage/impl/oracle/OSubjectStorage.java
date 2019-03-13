package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.OSubject;
import io.university.repository.oracle.OSubjectRepository;
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
public class OSubjectStorage extends BasicJpaStorage<OSubject, Integer> {

    @Autowired
    public OSubjectStorage(final OSubjectRepository repository) {
        super(repository);
    }
}
