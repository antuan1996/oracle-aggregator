package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.Schedule;
import io.university.repository.oracle.ScheduleRepository;
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
public class ScheduleStorage extends BasicJpaStorage<Schedule, Integer> {

    @Autowired
    public ScheduleStorage(final ScheduleRepository repository) {
        super(repository);
    }
}
