package io.university.storage.impl.common;

import io.university.model.dao.common.CPerson;
import io.university.repository.common.CPersonRepository;
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
public class CPersonStorage extends BasicJpaStorage<CPerson, Integer> {

    @Autowired
    public CPersonStorage(final CPersonRepository repository) {
        super(repository);
    }
}
