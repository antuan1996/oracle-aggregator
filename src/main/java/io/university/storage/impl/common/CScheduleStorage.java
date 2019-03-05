package io.university.storage.impl.common;

import io.university.model.dao.common.CSchedule;
import io.university.repository.common.CScheduleRepository;
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
public class CScheduleStorage extends BasicJpaStorage<CSchedule, Integer> {

    @Autowired
    public CScheduleStorage(final CScheduleRepository repository) {
        super(repository);
    }
}
