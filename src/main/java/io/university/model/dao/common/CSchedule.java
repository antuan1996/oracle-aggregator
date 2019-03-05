package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenInteger;
import io.dummymaker.annotation.simple.number.GenShort;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 05.03.2019
 */
@Entity
@Table(schema = "sys")
public class CSchedule implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenTime
    private Timestamp startTimestamp;
    @GenTime
    private Timestamp endTimestamp;
    @GenShort
    private String audience;
    @GenInteger
    private Integer campusId;

    @ManyToMany(mappedBy = "schedules", cascade = CascadeType.ALL)
    private Set<CPerson> people = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_uid")
    private CSubject subject;

    public int getId() {
        return id;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public Timestamp getEndTimestamp() {
        return endTimestamp;
    }

    public String getAudience() {
        return audience;
    }

    public int getCampusId() {
        return campusId;
    }

    public Set<CPerson> getPeople() {
        return people;
    }

    public CPerson addPerson(CPerson person) {
        this.people.add(person);
        return person;
    }

    public CSubject getSubject() {
        return subject;
    }

    public void setSubject(CSubject subject) {
        this.subject = subject;
    }

}
