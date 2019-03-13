package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.OSpeciality;
import io.university.repository.oracle.OSpecialityRepository;
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
public class OSpecialityStorage extends BasicJpaStorage<OSpeciality, Integer> {

    @Autowired
    public OSpecialityStorage(final OSpecialityRepository repository) {
        super(repository);
    }
}
