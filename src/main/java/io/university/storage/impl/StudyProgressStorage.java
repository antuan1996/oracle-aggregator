package io.university.storage.impl;

import io.university.model.dao.StudyProgress;
import io.university.repository.StudyProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Component
public class StudyProgressStorage extends BasicJpaStorage<StudyProgress, Integer> {

    @Autowired
    public StudyProgressStorage(final StudyProgressRepository repository) {
        super(repository);
    }
}
