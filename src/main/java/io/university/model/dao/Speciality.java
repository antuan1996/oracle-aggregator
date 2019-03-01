package io.university.model.dao;

import io.dummymaker.annotation.simple.number.GenInteger;
import io.dummymaker.annotation.simple.string.GenCompany;
import io.dummymaker.annotation.simple.string.GenNick;
import io.dummymaker.annotation.simple.string.GenNoun;

import javax.persistence.*;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @GenInteger
    private int code;
    @GenNick
    private String type;
    @GenNoun
    private String course;
    @GenCompany
    private String qualification;

    @OneToMany(mappedBy = "speciality")
    private List<Subject> subjects;

    @OneToOne(mappedBy = "speciality")
    private StudyProgress studyProgress;

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getCourse() {
        return course;
    }

    public String getQualification() {
        return qualification;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public StudyProgress getStudyProgress() {
        return studyProgress;
    }
}
