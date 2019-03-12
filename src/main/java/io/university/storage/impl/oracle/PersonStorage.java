package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.Person;
import io.university.repository.oracle.PersonRepository;
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
public class PersonStorage extends BasicJpaStorage<Person, Integer> {

    @Autowired
    public PersonStorage(final PersonRepository repository) {
        super(repository);
    }
}
