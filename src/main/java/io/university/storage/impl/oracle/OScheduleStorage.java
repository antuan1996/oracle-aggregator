package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.OSchedule;
import io.university.repository.oracle.OScheduleRepository;
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
public class OScheduleStorage extends BasicJpaStorage<OSchedule, Integer> {

    @Autowired
    public OScheduleStorage(final OScheduleRepository repository) {
        super(repository);
    }
}
