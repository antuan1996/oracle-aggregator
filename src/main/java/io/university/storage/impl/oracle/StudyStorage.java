package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.Study;
import io.university.repository.oracle.StudyRepository;
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
public class StudyStorage extends BasicJpaStorage<Study, Integer> {

    @Autowired
    public StudyStorage(final StudyRepository repository) {
        super(repository);
    }
}
