package io.university.storage.impl.common;

import io.university.model.dao.common.CProjectParticipation;
import io.university.repository.common.CProjectParticipationRepository;
import io.university.storage.impl.BasicJpaStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@Component
public class CProjectParticipationStorage extends BasicJpaStorage<CProjectParticipation, Integer> {

    @Autowired
    public CProjectParticipationStorage(final CProjectParticipationRepository repository) {
        super(repository);
    }
}
