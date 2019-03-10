package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenSet;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.GenUuid;
import io.dummymaker.annotation.simple.string.GenName;
import io.dummymaker.generator.simple.impl.EmbeddedGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@Entity
public class CBook {

    @Id
    @GeneratedValue
    private int id;

    @GenUuid
    private String ISBN;

    @GenName
    private String name;

    @GenTime
    private Timestamp publishTimestamp;

    @GenSet(value = EmbeddedGenerator.class, depth = 8)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<CReading> readings;

    public int getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public Timestamp getPublishTimestamp() {
        return publishTimestamp;
    }

    public Set<CReading> getReadings() {
        return readings;
    }

    public CReading addReading(CReading reading) {
        this.readings.add(reading);
        return reading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CBook cBook = (CBook) o;

        if (id != cBook.id) return false;
        if (ISBN != null ? !ISBN.equals(cBook.ISBN) : cBook.ISBN != null) return false;
        if (name != null ? !name.equals(cBook.name) : cBook.name != null) return false;
        return publishTimestamp != null ? publishTimestamp.equals(cBook.publishTimestamp) : cBook.publishTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ISBN != null ? ISBN.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publishTimestamp != null ? publishTimestamp.hashCode() : 0);
        return result;
    }
}
