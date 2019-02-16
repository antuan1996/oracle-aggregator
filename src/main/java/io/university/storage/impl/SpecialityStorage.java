package io.university.storage.impl;

import io.university.repository.SpecialityRepository;
import model.dao.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class SpecialityStorage extends BasicSqlStorage<Speciality, Integer> {

    @Autowired
    public SpecialityStorage(final SpecialityRepository repository) {
        super(repository);
    }
}
