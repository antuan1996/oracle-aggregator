package io.university.storage.impl.common;

import io.university.model.dao.common.CBook;
import io.university.repository.common.CBookRepository;
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
public class CBookStorage extends BasicJpaStorage<CBook, Integer> {

    @Autowired
    public CBookStorage(final CBookRepository repository) {
        super(repository);
    }
}
