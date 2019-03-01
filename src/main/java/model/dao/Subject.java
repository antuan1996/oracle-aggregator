package model.dao;

import io.dummymaker.annotation.complex.GenList;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenInteger;
import io.dummymaker.annotation.simple.number.GenShort;
import io.dummymaker.annotation.simple.string.GenNoun;
import io.dummymaker.annotation.special.GenEmbedded;
import io.dummymaker.generator.simple.impl.EmbeddedGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Subject {

    @Id @GeneratedValue private int id;

    @GenInteger
    private int code;
    @GenNoun
    private String name;
    @GenShort
    private String semester;
    @GenTime
    private Timestamp start_timestamp;
    @GenTime
    private Timestamp end_timestamp;

    @OneToOne(mappedBy = "subject") private Schedule schedule;
    @GenList(value = EmbeddedGenerator.class, depth = 5)
    @OneToMany(mappedBy = "subject") private List<Grade> grades;

    @GenEmbedded(depth = 5)
    @ManyToOne
    @JoinColumn(name="speciality_id")
    private Speciality speciality;

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

    public Timestamp getStart_timestamp() {
        return start_timestamp;
    }

    public Timestamp getEnd_timestamp() {
        return end_timestamp;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}

