package io.university.storage.impl.common;

import io.university.model.dao.common.CProject;
import io.university.repository.common.CProjectRepository;
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
public class CProjectStorage extends BasicJpaStorage<CProject, Integer> {

    @Autowired
    public CProjectStorage(final CProjectRepository repository) {
        super(repository);
    }
}
