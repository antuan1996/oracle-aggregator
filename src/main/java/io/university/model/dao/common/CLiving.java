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
    private Integer id;

    @GenTime
    private Timestamp enterTimestamp;

    @GenTime
    private Timestamp exitTimestamp;

    @GenUInteger
    private Integer enterCource;

    @GenUInteger
    private Integer invoiceCount;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_uid")
    private CRoom room;

    public Integer getId() {
        return id;
    }

    public Timestamp getEnterTimestamp() {
        return enterTimestamp;
    }

    public Timestamp getExitTimestamp() {
        return exitTimestamp;
    }

    public Integer getEnterCource() {
        return enterCource;
    }

    public Integer getInvoiceCount() {
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

        CLiving living = (CLiving) o;

        if (id != null ? !id.equals(living.id) : living.id != null) return false;
        if (enterTimestamp != null ? !enterTimestamp.equals(living.enterTimestamp) : living.enterTimestamp != null)
            return false;
        if (exitTimestamp != null ? !exitTimestamp.equals(living.exitTimestamp) : living.exitTimestamp != null)
            return false;
        if (enterCource != null ? !enterCource.equals(living.enterCource) : living.enterCource != null) return false;
        return invoiceCount != null ? invoiceCount.equals(living.invoiceCount) : living.invoiceCount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (enterTimestamp != null ? enterTimestamp.hashCode() : 0);
        result = 31 * result + (exitTimestamp != null ? exitTimestamp.hashCode() : 0);
        result = 31 * result + (enterCource != null ? enterCource.hashCode() : 0);
        result = 31 * result + (invoiceCount != null ? invoiceCount.hashCode() : 0);
        return result;
    }
}
