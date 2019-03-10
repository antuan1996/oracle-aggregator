package io.university.repository.common;

import io.university.model.dao.common.CProjectParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@Repository
public interface CProjectParticipationRepository extends JpaRepository<CProjectParticipation, Integer> {

}
