package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenSet;
import io.dummymaker.annotation.simple.number.GenUInteger;
import io.dummymaker.annotation.simple.string.GenCity;
import io.dummymaker.annotation.simple.string.GenCountry;
import io.dummymaker.generator.simple.impl.EmbeddedGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 11.03.2019
 */
@Entity
public class CCommunity {

    @Id
    @GeneratedValue
    private int id;

    @GenUInteger
    private int roomNumber;

    @GenUInteger
    private int payRentPerPerson;

    @GenCountry
    private String district;

    @GenCity
    private String street;

    @GenUInteger
    private int houseNumber;

    @GenUInteger
    private int housingNumber;

    @GenSet(value = EmbeddedGenerator.class, depth = 8)
    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private Set<CRoom> rooms = new HashSet<>();

    @GenSet(value = EmbeddedGenerator.class, depth = 8)
    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private Set<CVisit> visits = new HashSet<>();

    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getPayRentPerPerson() {
        return payRentPerPerson;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getHousingNumber() {
        return housingNumber;
    }

    public Set<CRoom> getRooms() {
        return rooms;
    }

    public CRoom addRoom(CRoom room) {
        this.rooms.add(room);
        return room;
    }

    public Set<CVisit> getVisits() {
        return visits;
    }

    public CVisit addVisit(CVisit visit) {
        this.visits.add(visit);
        return visit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CCommunity that = (CCommunity) o;

        if (id != that.id) return false;
        if (roomNumber != that.roomNumber) return false;
        if (payRentPerPerson != that.payRentPerPerson) return false;
        if (houseNumber != that.houseNumber) return false;
        if (housingNumber != that.housingNumber) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        return street != null ? street.equals(that.street) : that.street == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roomNumber;
        result = 31 * result + payRentPerPerson;
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + houseNumber;
        result = 31 * result + housingNumber;
        return result;
    }
}
