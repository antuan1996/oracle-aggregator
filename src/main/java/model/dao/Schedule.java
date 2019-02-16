package model.dao;

import javax.persistence.*;
import java.sql.Time;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Schedule {

    @Id @GeneratedValue private int id;

    private Time start_timestamp;
    private Time end_timestamp;
    private String audience;
    private int campus_id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
