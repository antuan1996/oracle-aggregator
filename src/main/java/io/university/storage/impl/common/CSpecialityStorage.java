package io.university.storage.impl.common;

import io.university.model.dao.common.CSpeciality;
import io.university.repository.common.CSpecialityRepository;
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
public class CSpecialityStorage extends BasicJpaStorage<CSpeciality, Integer> {

    @Autowired
    public CSpecialityStorage(final CSpecialityRepository repository) {
        super(repository);
    }
}
