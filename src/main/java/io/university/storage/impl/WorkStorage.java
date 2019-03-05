package io.university.storage.impl;

import io.university.model.dao.WorkHistory;
import io.university.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class WorkStorage extends BasicJpaStorage<WorkHistory, Integer> {

    @Autowired
    public WorkStorage(final WorkRepository repository) {
        super(repository);
    }
}
