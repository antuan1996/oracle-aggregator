package io.university.storage.impl;

import io.university.repository.SubjectRepository;
import model.dao.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class SubjectStorage extends BasicSqlStorage<Subject, Integer> {

    @Autowired
    public SubjectStorage(final SubjectRepository repository) {
        super(repository);
    }
}
