package io.university.storage.impl.common;

import io.university.model.dao.common.CGrade;
import io.university.repository.common.CGradeRepository;
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
public class CGradeStorage extends BasicJpaStorage<CGrade, String> {

    @Autowired
    public CGradeStorage(final CGradeRepository repository) {
        super(repository);
    }
}
