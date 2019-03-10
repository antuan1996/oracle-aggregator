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
public class CProjectParticipation {

    @Id
    @GeneratedValue
    private int id;

    @GenTime
    private Timestamp startTimestamp;

    @GenTime
    private Timestamp endTimestamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_uid")
    private CProject project;

    public int getId() {
        return id;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public Timestamp getEndTimestamp() {
        return endTimestamp;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }

    public CProject getProject() {
        return project;
    }

    public void setProject(CProject project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CProjectParticipation that = (CProjectParticipation) o;

        if (id != that.id) return false;
        if (startTimestamp != null ? !startTimestamp.equals(that.startTimestamp) : that.startTimestamp != null)
            return false;
        return endTimestamp != null ? endTimestamp.equals(that.endTimestamp) : that.endTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startTimestamp != null ? startTimestamp.hashCode() : 0);
        result = 31 * result + (endTimestamp != null ? endTimestamp.hashCode() : 0);
        return result;
    }
}
