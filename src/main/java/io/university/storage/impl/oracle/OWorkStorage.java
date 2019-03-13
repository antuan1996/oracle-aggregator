package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.OWorkHistory;
import io.university.repository.oracle.OWorkRepository;
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
public class OWorkStorage extends BasicJpaStorage<OWorkHistory, Integer> {

    @Autowired
    public OWorkStorage(final OWorkRepository repository) {
        super(repository);
    }
}
