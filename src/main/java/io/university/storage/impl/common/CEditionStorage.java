package io.university.storage.impl.common;

import io.university.model.dao.common.CEdition;
import io.university.repository.common.CEditionRepository;
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
public class CEditionStorage extends BasicJpaStorage<CEdition, Integer> {

    @Autowired
    public CEditionStorage(final CEditionRepository repository) {
        super(repository);
    }
}
