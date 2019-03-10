package io.university.storage.impl.common;

import io.university.model.dao.common.CCommunity;
import io.university.repository.common.CCommunityRepository;
import io.university.storage.impl.BasicJpaStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 11.03.2019
 */
@Component
public class CCommunityStorage extends BasicJpaStorage<CCommunity, Integer> {

    @Autowired
    public CCommunityStorage(final CCommunityRepository repository) {
        super(repository);
    }
}
