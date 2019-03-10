package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.string.GenName;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@Entity
public class CPublishment {

    @Id
    @GeneratedValue
    private int id;

    @GenName
    private String name;

    @GenTime
    private Timestamp publish_timestamp;

    @ManyToMany(mappedBy = "publishments", cascade = CascadeType.ALL)
    private Set<CEdition> editions = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getPublish_timestamp() {
        return publish_timestamp;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }

    public Set<CEdition> getEditions() {
        return editions;
    }

    public CEdition addEdition(CEdition edition) {
        this.editions.add(edition);
        return edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CPublishment that = (CPublishment) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return publish_timestamp != null ? publish_timestamp.equals(that.publish_timestamp) : that.publish_timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publish_timestamp != null ? publish_timestamp.hashCode() : 0);
        return result;
    }
}
