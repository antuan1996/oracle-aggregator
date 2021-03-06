package io.university.storage.impl.common;

import io.university.model.dao.common.CPerson;
import io.university.repository.common.CPersonRepository;
import io.university.storage.impl.BasicJpaStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class CPersonStorage extends BasicJpaStorage<CPerson, Integer> {

    private CPersonRepository personRepository = (CPersonRepository) repository;

    @Autowired
    public CPersonStorage(final CPersonRepository repository) {
        super(repository);
    }

    public List<CPerson> findByFullName(final String name,
                                        final String middleName,
                                        final String surname
    ) {
        return personRepository.findByNameAndMiddleNameAndSurname(name, middleName, surname);
    }

    public List<CPerson> findByBirth(final String birthPlace,
                                     final Timestamp birthTimestamp
    ) {
        return personRepository.findByBirthPlaceAndBirthTimestamp(birthPlace, birthTimestamp);
    }

    public Optional<CPerson> findByFullNameAndBirth(final String name,
                                                    final String middleName,
                                                    final String surname,
                                                    final String birthPlace,
                                                    final Timestamp birthTimestamp
    ) {
        return personRepository.findByNameAndMiddleNameAndSurnameAndBirthPlaceAndBirthTimestamp(name, middleName, surname, birthPlace, birthTimestamp);
    }
}
