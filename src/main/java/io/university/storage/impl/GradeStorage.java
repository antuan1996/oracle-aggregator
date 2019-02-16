package io.university.storage.impl;

import io.university.repository.GradeRepository;
import model.dao.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class GradeStorage extends BasicSqlStorage<Grade, Integer> {

    @Autowired
    public GradeStorage(final GradeRepository repository) {
        super(repository);
    }
}
