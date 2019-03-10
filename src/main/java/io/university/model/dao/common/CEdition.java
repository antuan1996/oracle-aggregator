package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenEnum;
import io.dummymaker.annotation.complex.GenSet;
import io.dummymaker.annotation.simple.number.GenUInteger;
import io.dummymaker.annotation.simple.string.GenCity;
import io.dummymaker.annotation.simple.string.GenCountry;
import io.dummymaker.annotation.simple.string.GenName;
import io.dummymaker.generator.simple.impl.EmbeddedGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@Entity
public class CEdition {

    public enum Lang {
        EN,
        RU,
        CH,
        FR
    }

    @Id
    @GeneratedValue
    private int id;

    @GenName
    private String name;

    @GenEnum
    private Lang lang;

    @GenCity
    private String city;

    @GenUInteger
    private int pages;

    @GenCountry
    private String type;

    @GenSet(value = EmbeddedGenerator.class, depth = 8)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cedition_mapper",
            joinColumns = { @JoinColumn(name = "edition_id") },
            inverseJoinColumns = { @JoinColumn(name = "publishment_id") }
    )
    private Set<CPublishment> publishments = new HashSet<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Lang getLang() {
        return lang;
    }

    public String getCity() {
        return city;
    }

    public int getPages() {
        return pages;
    }

    public String getType() {
        return type;
    }

    public Set<CPublishment> getPublishments() {
        return publishments;
    }

    public CPublishment addPublishment(CPublishment publishment) {
        this.publishments.add(publishment);
        return publishment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CEdition cEdition = (CEdition) o;

        if (id != cEdition.id) return false;
        if (pages != cEdition.pages) return false;
        if (name != null ? !name.equals(cEdition.name) : cEdition.name != null) return false;
        if (lang != cEdition.lang) return false;
        if (city != null ? !city.equals(cEdition.city) : cEdition.city != null) return false;
        return type != null ? type.equals(cEdition.type) : cEdition.type == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + pages;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
