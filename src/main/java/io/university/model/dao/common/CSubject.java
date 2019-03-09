package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenList;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenUByte;
import io.dummymaker.annotation.simple.number.GenUInteger;
import io.dummymaker.annotation.simple.string.GenCountry;
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
 * @since 05.03.2019
 */
@Entity
@Table(schema = "sys")
public class CSubject implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenUInteger
    private int code;

    @GenCountry
    private String name;

    @GenUByte
    private String semester;

    @GenTime
    private Timestamp startTimestamp;

    @GenTime
    private Timestamp endTimestamp;

    @GenEmbedded(depth = 7)
    @OneToOne(mappedBy = "subject")
    private CSchedule schedule;

    @GenList(value = EmbeddedGenerator.class, depth = 7)
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<CGrade> grades = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality_uid")
    private CSpeciality speciality;

    public CSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(CSpeciality speciality) {
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

    public CSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(CSchedule schedule) {
        this.schedule = schedule;
    }

    public List<CGrade> getGrades() {
        return grades;
    }

    public CGrade addGrade(CGrade grade) {
        this.grades.add(grade);
        return grade;
    }
}
