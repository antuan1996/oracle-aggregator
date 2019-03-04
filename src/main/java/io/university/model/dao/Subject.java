package io.university.model.dao;

import io.dummymaker.annotation.complex.GenList;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenInteger;
import io.dummymaker.annotation.simple.number.GenShort;
import io.dummymaker.annotation.simple.string.GenNoun;
import io.dummymaker.annotation.special.GenEmbedded;
import io.dummymaker.generator.simple.impl.EmbeddedGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
@Table(schema = "sys")
public class Subject implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenInteger
    private int code;

    @GenNoun
    private String name;

    @GenShort
    private String semester;

    @GenTime
    private Timestamp startTimestamp;

    @GenTime
    private Timestamp endTimestamp;

    @GenEmbedded(depth = 7)
    @OneToOne(mappedBy = "subject")
    private Schedule schedule;

    @GenList(value = EmbeddedGenerator.class, depth = 7)
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Grade> grades = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality_uid")
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public Timestamp getEndTimestamp() {
        return endTimestamp;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Grade addGrade(Grade grade) {
        this.grades.add(grade);
        return grade;
    }

//    public Speciality getSpeciality() {
//        return speciality;
//    }
}

