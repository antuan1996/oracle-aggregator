package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenTime;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@Entity
public class CReading {

    @Id
    @GeneratedValue
    private int id;

    @GenTime
    private Timestamp takeTimestamp;

    @GenTime
    private Timestamp returnTimestamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_uid")
    private CBook book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    public int getId() {
        return id;
    }

    public Timestamp getTakeTimestamp() {
        return takeTimestamp;
    }

    public Timestamp getReturnTimestamp() {
        return returnTimestamp;
    }

    public CBook getBook() {
        return book;
    }

    public void setBook(CBook book) {
        this.book = book;
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

        CReading cReading = (CReading) o;

        if (id != cReading.id) return false;
        if (takeTimestamp != null ? !takeTimestamp.equals(cReading.takeTimestamp) : cReading.takeTimestamp != null)
            return false;
        return returnTimestamp != null ? returnTimestamp.equals(cReading.returnTimestamp) : cReading.returnTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (takeTimestamp != null ? takeTimestamp.hashCode() : 0);
        result = 31 * result + (returnTimestamp != null ? returnTimestamp.hashCode() : 0);
        return result;
    }
}
