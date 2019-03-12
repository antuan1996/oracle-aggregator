package io.university.model.dao.common;

import io.dummymaker.annotation.complex.GenEnum;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.GenBoolean;
import io.dummymaker.annotation.simple.number.GenUByte;
import io.dummymaker.annotation.simple.string.GenCity;
import io.dummymaker.annotation.simple.string.GenName;
import io.dummymaker.annotation.simple.string.GenSurname;
import io.dummymaker.annotation.special.GenEmbedded;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 05.03.2019
 */
@Entity
@Table(schema = "sys")
public class CPerson implements Serializable {

    public enum CPersonType {
        STUDENT,
        TEACHER
    }

    @Id
    @GeneratedValue
    private Integer id;

    @GenName
    private String name;

    @GenName
    private String middleName;

    @GenSurname
    private String surname;

    @GenTime
    private Timestamp birthTimestamp;

    @GenCity
    private String birthPlace;

    @GenEnum
    private CPersonType personType;

    @GenBoolean
    private Boolean havePrivilage;

    @GenUByte
    private Integer citationIndex;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cschedule_mapper",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "schedule_id") }
    )
    private Set<CSchedule> schedules = new HashSet<>();

    @GenEmbedded
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private CWorkHistory workHistory;

    @GenEmbedded
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private CStudy study;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<CProjectParticipation> participations = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<CPublishment> publishments = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<CReading> readings = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<CGrade> grades = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<CVisit> visits = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<CLiving> livings = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cconference_mapper",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "conference_id") }
    )
    private Set<CConference> conferences = new HashSet<>();

    public int getId() {
        return id;
    }

    public Boolean getHavePrivilage() {
        return havePrivilage;
    }

    public Integer getCitationIndex() {
        return citationIndex;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public Timestamp getBirthTimestamp() {
        return birthTimestamp;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public CStudy getStudy() {
        return study;
    }

    public void setStudy(CStudy study) {
        this.study = study;
    }

    public CPersonType getPersonType() {
        return personType;
    }

    public CWorkHistory getWorkHistory() {
        return workHistory;
    }

    public Set<CSchedule> getSchedules() {
        return schedules;
    }

    public CSchedule addSchedule(CSchedule schedule) {
        this.schedules.add(schedule);
        return schedule;
    }

    public Set<CConference> getConferences() {
        return conferences;
    }

    public CConference addConference(CConference conference) {
        this.conferences.add(conference);
        return conference;
    }

    public Set<CProjectParticipation> getParticipations() {
        return participations;
    }

    public CProjectParticipation addParticipation(CProjectParticipation participation) {
        this.participations.add(participation);
        return participation;
    }

    public Set<CPublishment> getPublishments() {
        return publishments;
    }

    public CPublishment addPublishment(CPublishment publishment) {
        this.publishments.add(publishment);
        return publishment;
    }

    public Set<CReading> getReadings() {
        return readings;
    }

    public CReading addReading(CReading reading) {
        this.readings.add(reading);
        return reading;
    }

    public Set<CGrade> getGrades() {
        return grades;
    }

    public CGrade addGrade(CGrade grade) {
        this.grades.add(grade);
        grade.setPerson(this);
        return grade;
    }

    public Set<CVisit> getVisits() {
        return visits;
    }

    public CVisit addVisit(CVisit visit) {
        this.visits.add(visit);
        return visit;
    }

    public Set<CLiving> getLivings() {
        return livings;
    }

    public CLiving addLiving(CLiving living) {
        this.livings.add(living);
        return living;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CPerson cPerson = (CPerson) o;

        if (id != null ? !id.equals(cPerson.id) : cPerson.id != null) return false;
        if (name != null ? !name.equals(cPerson.name) : cPerson.name != null) return false;
        if (middleName != null ? !middleName.equals(cPerson.middleName) : cPerson.middleName != null) return false;
        if (surname != null ? !surname.equals(cPerson.surname) : cPerson.surname != null) return false;
        if (birthTimestamp != null ? !birthTimestamp.equals(cPerson.birthTimestamp) : cPerson.birthTimestamp != null)
            return false;
        if (birthPlace != null ? !birthPlace.equals(cPerson.birthPlace) : cPerson.birthPlace != null) return false;
        if (personType != cPerson.personType) return false;
        if (havePrivilage != null ? !havePrivilage.equals(cPerson.havePrivilage) : cPerson.havePrivilage != null)
            return false;
        return citationIndex != null ? citationIndex.equals(cPerson.citationIndex) : cPerson.citationIndex == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthTimestamp != null ? birthTimestamp.hashCode() : 0);
        result = 31 * result + (birthPlace != null ? birthPlace.hashCode() : 0);
        result = 31 * result + (personType != null ? personType.hashCode() : 0);
        result = 31 * result + (havePrivilage != null ? havePrivilage.hashCode() : 0);
        result = 31 * result + (citationIndex != null ? citationIndex.hashCode() : 0);
        return result;
    }
}
