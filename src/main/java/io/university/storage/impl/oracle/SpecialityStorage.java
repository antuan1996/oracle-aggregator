package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.Speciality;
import io.university.repository.oracle.SpecialityRepository;
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
public class SpecialityStorage extends BasicJpaStorage<Speciality, Integer> {

    @Autowired
    public SpecialityStorage(final SpecialityRepository repository) {
        super(repository);
    }
}
