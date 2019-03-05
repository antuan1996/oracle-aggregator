package io.university.storage.impl.common;

import io.university.model.dao.common.CWorkHistory;
import io.university.repository.common.CWorkRepository;
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
public class CWorkStorage extends BasicJpaStorage<CWorkHistory, Integer> {

    @Autowired
    public CWorkStorage(final CWorkRepository repository) {
        super(repository);
    }
}
