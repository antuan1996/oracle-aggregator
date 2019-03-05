package io.university.repository.common;

import io.university.model.dao.common.CDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Repository
public interface CDepartmentRepository extends JpaRepository<CDepartment, Integer> {

}
