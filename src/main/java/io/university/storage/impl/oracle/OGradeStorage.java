package io.university.storage.impl.oracle;

import io.university.model.dao.oracle.OGrade;
import io.university.repository.oracle.OGradeRepository;
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
public class OGradeStorage extends BasicJpaStorage<OGrade, String> {

    @Autowired
    public OGradeStorage(final OGradeRepository repository) {
        super(repository);
    }
}
