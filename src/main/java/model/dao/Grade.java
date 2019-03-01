package model.dao;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenChar;
import io.dummymaker.annotation.simple.number.GenInteger;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Grade {

    @Id @GeneratedValue private int id;

    @GenInteger
    private int value;
    @GenChar
    private char latin_value;
    @GenTime
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public char getLatin_value() {
        return latin_value;
    }

    public Timestamp getDate() {
        return date;
    }

    public Subject getSubject() {
        return subject;
    }
}
