package io.university.model.dao.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dummymaker.annotation.complex.GenTime;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 11.03.2019
 */
@Entity
public class CVisit {

    @Id
    @GeneratedValue
    private int id;

    @GenTime
    private Timestamp enterTimestamp;

    @GenTime
    private Timestamp exitTimestamp;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "community_uid")
    private CCommunity community;

    public int getId() {
        return id;
    }

    public Timestamp getEnterTimestamp() {
        return enterTimestamp;
    }

    public Timestamp getExitTimestamp() {
        return exitTimestamp;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }

    public CCommunity getCommunity() {
        return community;
    }

    public void setCommunity(CCommunity community) {
        this.community = community;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CVisit cVisit = (CVisit) o;

        if (id != cVisit.id) return false;
        if (enterTimestamp != null ? !enterTimestamp.equals(cVisit.enterTimestamp) : cVisit.enterTimestamp != null)
            return false;
        return exitTimestamp != null ? exitTimestamp.equals(cVisit.exitTimestamp) : cVisit.exitTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (enterTimestamp != null ? enterTimestamp.hashCode() : 0);
        result = 31 * result + (exitTimestamp != null ? exitTimestamp.hashCode() : 0);
        return result;
    }
}
