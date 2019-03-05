package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenChar;
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

    @GenChar
    private char latinValue;

    @GenTime
    private Timestamp gradeTimestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_uid")
    private CSubject subject;

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
}
