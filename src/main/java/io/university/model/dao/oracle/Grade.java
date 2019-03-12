package io.university.model.dao.oracle;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenCharacter;
import io.dummymaker.annotation.simple.number.GenUShort;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
@Table(schema = "sys")
public class Grade implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenUShort
    private int numValue;

    @GenCharacter
    private char latinValue;

    @GenTime
    private Timestamp gradeTimestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_uid")
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private Person person;

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (id != grade.id) return false;
        if (numValue != grade.numValue) return false;
        if (latinValue != grade.latinValue) return false;
        return gradeTimestamp != null ? gradeTimestamp.equals(grade.gradeTimestamp) : grade.gradeTimestamp == null;
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
