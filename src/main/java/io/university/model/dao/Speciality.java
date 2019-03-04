package io.university.model.dao;

import io.dummymaker.annotation.complex.GenList;
import io.dummymaker.annotation.simple.number.GenInteger;
import io.dummymaker.annotation.simple.string.GenCompany;
import io.dummymaker.annotation.simple.string.GenNick;
import io.dummymaker.annotation.simple.string.GenNoun;
import io.dummymaker.generator.simple.impl.EmbeddedGenerator;

import javax.persistence.*;
import java.io.Serializable;
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
public class Speciality implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenInteger
    private int code;

    @GenNick
    private String type;

    @GenNoun
    private String course;

    @GenCompany
    private String qualification;

    @GenList(value = EmbeddedGenerator.class, depth = 8)
    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    @OneToOne(mappedBy = "speciality", cascade = CascadeType.ALL)
    private Study study;

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

    public Subject addSubject(Subject subject) {
        this.subjects.add(subject);
        return subject;
    }

    public Study getStudy() {
        return study;
    }
}
