package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenCharacter;
import io.dummymaker.annotation.simple.number.GenInteger;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 05.03.2019
 */
@Entity
@Table(schema = "sys")
public class CGrade implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenInteger
    private int numValue;

    @GenCharacter
    private char latinValue;

    @GenTime
    private Timestamp gradeTimestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_uid")
    private CSubject subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    public int getId() {
        return id;
    }

    public int getNumValue() {
        return numValue;
    }

    public char getLatinValue() {
        return latinValue;
    }

    public Timestamp getGradeTimestamp() {
        return gradeTimestamp;
    }

    public CSubject getSubject() {
        return subject;
    }

    public void setSubject(CSubject subject) {
        this.subject = subject;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CGrade cGrade = (CGrade) o;

        if (id != cGrade.id) return false;
        if (numValue != cGrade.numValue) return false;
        if (latinValue != cGrade.latinValue) return false;
        return gradeTimestamp != null ? gradeTimestamp.equals(cGrade.gradeTimestamp) : cGrade.gradeTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + numValue;
        result = 31 * result + (int) latinValue;
        result = 31 * result + (gradeTimestamp != null ? gradeTimestamp.hashCode() : 0);
        return result;
    }
}
