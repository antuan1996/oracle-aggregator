package io.university.storage.impl;

import io.university.repository.WorkProgressRepository;
import model.dao.WorkProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class WorkProgressStorage extends BasicJpaStorage<WorkProgress, Integer> {

    @Autowired
    public WorkProgressStorage(final WorkProgressRepository repository) {
        super(repository);
    }
}
