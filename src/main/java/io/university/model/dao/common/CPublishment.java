package io.university.model.dao.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;

    @GenName
    private String name;

    @GenTime
    private Timestamp publishTimestamp;

    @ManyToMany(mappedBy = "publishments", cascade = CascadeType.ALL)
    private Set<CEdition> editions = new HashSet<>();

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_uid")
    private CPerson person;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getPublishTimestamp() {
        return publishTimestamp;
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return publishTimestamp != null ? publishTimestamp.equals(that.publishTimestamp) : that.publishTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publishTimestamp != null ? publishTimestamp.hashCode() : 0);
        return result;
    }
}
