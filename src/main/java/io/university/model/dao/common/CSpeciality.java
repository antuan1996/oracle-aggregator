package io.university.model.dao.common;

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
 * @since 05.03.2019
 */
@Entity
@Table(schema = "sys")
public class CSpeciality implements Serializable {

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
    private List<CSubject> subjects = new ArrayList<>();

    @OneToOne(mappedBy = "speciality", cascade = CascadeType.ALL)
    private CStudy study;

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

    public List<CSubject> getSubjects() {
        return subjects;
    }

    public CSubject addSubject(CSubject subject) {
        this.subjects.add(subject);
        return subject;
    }

    public CStudy getStudy() {
        return study;
    }
}
