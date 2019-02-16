package io.university.storage.impl;

import io.university.repository.PersonRepository;
import model.dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class PersonStorage extends BasicSqlStorage<Person, Integer> {

    @Autowired
    public PersonStorage(final PersonRepository repository) {
        super(repository);
    }
}
