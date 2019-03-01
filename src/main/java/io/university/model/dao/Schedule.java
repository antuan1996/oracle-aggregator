package io.university.model.dao;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenInteger;
import io.dummymaker.annotation.simple.number.GenShort;
import io.dummymaker.annotation.special.GenEmbedded;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @GenTime
    private Time start_timestamp;
    @GenTime
    private Time end_timestamp;
    @GenShort
    private String audience;
    @GenInteger
    private int campus_id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @GenEmbedded(depth = 5)
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public int getId() {
        return id;
    }

    public Time getStart_timestamp() {
        return start_timestamp;
    }

    public Time getEnd_timestamp() {
        return end_timestamp;
    }

    public String getAudience() {
        return audience;
    }

    public int getCampus_id() {
        return campus_id;
    }

    public Person getPerson() {
        return person;
    }

    public Subject getSubject() {
        return subject;
    }
}
