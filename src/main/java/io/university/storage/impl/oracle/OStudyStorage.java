package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.OStudy;
import io.university.repository.oracle.OStudyRepository;
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
public class OStudyStorage extends BasicJpaStorage<OStudy, Integer> {

    @Autowired
    public OStudyStorage(final OStudyRepository repository) {
        super(repository);
    }
}
