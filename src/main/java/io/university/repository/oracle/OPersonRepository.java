package io.university.repository.oracle;

import io.university.model.dao.oracle.OPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Repository
public interface OPersonRepository extends JpaRepository<OPerson, Integer> {

}
