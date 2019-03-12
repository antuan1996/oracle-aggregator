package io.university.repository.oracle;

import io.university.model.dao.oracle.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
