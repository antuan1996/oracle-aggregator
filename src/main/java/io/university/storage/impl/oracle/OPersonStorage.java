package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.OPerson;
import io.university.repository.oracle.OPersonRepository;
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
public class OPersonStorage extends BasicJpaStorage<OPerson, Integer> {

    @Autowired
    public OPersonStorage(final OPersonRepository repository) {
        super(repository);
    }
}
