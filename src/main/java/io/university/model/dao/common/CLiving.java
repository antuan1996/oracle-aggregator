package io.university.model.dao.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenUInteger;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 11.03.2019
 */
@Entity
public class CLiving {

    @Id
    @GeneratedValue
    private int id;

    @GenTime
    private Timestamp enterTimestamp;

    @GenTime
    private Timestamp exitTimestamp;

    @GenUInteger
    private int enterCource;

    @GenUInteger
    private int invoiceCount;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_uid")
    private CRoom room;

    public int getId() {
        return id;
    }

    public Timestamp getEnterTimestamp() {
        return enterTimestamp;
    }

    public Timestamp getExitTimestamp() {
        return exitTimestamp;
    }

    public int getEnterCource() {
        return enterCource;
    }

    public int getInvoiceCount() {
        return invoiceCount;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }

    public CRoom getRoom() {
        return room;
    }

    public void setRoom(CRoom room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CLiving cLiving = (CLiving) o;

        if (id != cLiving.id) return false;
        if (enterCource != cLiving.enterCource) return false;
        if (invoiceCount != cLiving.invoiceCount) return false;
        if (enterTimestamp != null ? !enterTimestamp.equals(cLiving.enterTimestamp) : cLiving.enterTimestamp != null)
            return false;
        return exitTimestamp != null ? exitTimestamp.equals(cLiving.exitTimestamp) : cLiving.exitTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (enterTimestamp != null ? enterTimestamp.hashCode() : 0);
        result = 31 * result + (exitTimestamp != null ? exitTimestamp.hashCode() : 0);
        result = 31 * result + enterCource;
        result = 31 * result + invoiceCount;
        return result;
    }
}
