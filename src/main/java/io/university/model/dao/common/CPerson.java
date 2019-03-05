package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.string.GenCity;
import io.dummymaker.annotation.simple.string.GenName;
import io.dummymaker.annotation.special.GenEmbedded;

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
public class CPerson implements Serializable {

    public enum CPersonType {
        STUDENT,
        TEACHER
    }

    @Id
    @GeneratedValue
    private int id;

    @GenName
    private String name;

    @GenName
    private String middleName;

    @GenName
    private String surname;

    @GenTime
    private Timestamp birthTimestamp;

    @GenCity
    private String birthPlace;
    private CPersonType type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "schedule_mapper",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "schedule_id") }
    )
    private Set<CSchedule> schedules = new HashSet<>();

    @GenEmbedded
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private CWorkHistory workHistory;

    @GenEmbedded
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private CStudy study;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public Timestamp getBirthTimestamp() {
        return birthTimestamp;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public CStudy getStudy() {
        return study;
    }

    public CPersonType getType() {
        return type;
    }

    public CWorkHistory getWorkHistory() {
        return workHistory;
    }

    public Set<CSchedule> getSchedules() {
        return schedules;
    }

    public CSchedule addSchedule(CSchedule schedule) {
        this.schedules.add(schedule);
        return schedule;
    }
}
