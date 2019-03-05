package io.university.storage.impl.common;

import io.university.model.dao.common.CSubject;
import io.university.repository.common.CSubjectRepository;
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
public class CSubjectStorage extends BasicJpaStorage<CSubject, Integer> {

    @Autowired
    public CSubjectStorage(final CSubjectRepository repository) {
        super(repository);
    }
}
