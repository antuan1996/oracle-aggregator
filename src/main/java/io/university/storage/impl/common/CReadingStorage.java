package io.university.storage.impl.common;

import io.university.model.dao.common.CReading;
import io.university.repository.common.CReadingRepository;
import io.university.storage.impl.BasicJpaStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@Component
public class CReadingStorage extends BasicJpaStorage<CReading, Integer> {

    @Autowired
    public CReadingStorage(final CReadingRepository repository) {
        super(repository);
    }
}
