package io.university.storage.impl;

import io.university.repository.ScheduleRepository;
import model.dao.Schedule;
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
