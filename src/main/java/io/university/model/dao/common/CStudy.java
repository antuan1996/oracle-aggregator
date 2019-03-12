package io.university.model.dao.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenUShort;
import io.dummymaker.annotation.simple.string.GenHexNumber;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 05.03.2019
 */
@Entity
public class CStudy implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenHexNumber
    private String course;

    @GenUShort
    private String groupNum;

    @GenTime
    private Timestamp startTimestamp;

    @GenTime
    private Timestamp graduateTimestamp;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "person_uid")
    private CPerson person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_uid")
    private CDepartment department;

    @OneToOne
    @JoinColumn(name = "speciality_id")
    private CSpeciality speciality;

    public void setSpeciality(CSpeciality speciality) {
        this.speciality = speciality;
    }

    public CSpeciality getSpeciality() {
        return speciality;
    }

    public int getId() {
        return id;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setDepartment(CDepartment department) {
        this.department = department;
    }

    public CDepartment getDepartment() {
        return department;
    }

    public String getCourse() {
        return course;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public Timestamp getGraduateTimestamp() {
        return graduateTimestamp;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }
}
