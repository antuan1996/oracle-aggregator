package io.university.storage.impl.common;

import io.university.model.dao.common.CStudy;
import io.university.repository.common.CStudyRepository;
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
public class CStudyStorage extends BasicJpaStorage<CStudy, Integer> {

    @Autowired
    public CStudyStorage(final CStudyRepository repository) {
        super(repository);
    }
}
