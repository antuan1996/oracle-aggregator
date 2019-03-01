package io.university.repository;

import io.university.model.dao.WorkProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Repository
public interface WorkProgressRepository extends JpaRepository<WorkProgress, Integer> {

}
