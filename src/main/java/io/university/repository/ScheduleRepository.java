package io.university.repository;

import io.university.model.dao.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}