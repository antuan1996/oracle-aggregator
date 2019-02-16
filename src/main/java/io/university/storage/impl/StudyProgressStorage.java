package io.university.storage.impl;

import io.university.repository.StudyProgressRepository;
import model.dao.StudyProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class StudyProgressStorage extends BasicSqlStorage<StudyProgress, Integer> {

    @Autowired
    public StudyProgressStorage(final StudyProgressRepository repository) {
        super(repository);
    }
}
