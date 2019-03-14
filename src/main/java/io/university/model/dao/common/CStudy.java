package io.university.model.dao.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.GenBoolean;
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
    private Integer id;

    @GenHexNumber
    private String course;

    @GenUShort
    private String groupNum;

    @GenBoolean
    private Boolean isBudgetPaid;

    @GenBoolean
    private Boolean isFullTime;

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

    public Boolean getBudgetPaid() {
        return isBudgetPaid;
    }

    public Boolean getFullTime() {
        return isFullTime;
    }

    public Boolean isPaid() {
        return !isBudgetPaid;
    }

    public Boolean isPartTime() {
        return !isFullTime;
    }

    public Integer getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CStudy cStudy = (CStudy) o;

        if (id != null ? !id.equals(cStudy.id) : cStudy.id != null) return false;
        if (course != null ? !course.equals(cStudy.course) : cStudy.course != null) return false;
        if (groupNum != null ? !groupNum.equals(cStudy.groupNum) : cStudy.groupNum != null) return false;
        if (isBudgetPaid != null ? !isBudgetPaid.equals(cStudy.isBudgetPaid) : cStudy.isBudgetPaid != null)
            return false;
        return isFullTime != null ? isFullTime.equals(cStudy.isFullTime) : cStudy.isFullTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (groupNum != null ? groupNum.hashCode() : 0);
        result = 31 * result + (isBudgetPaid != null ? isBudgetPaid.hashCode() : 0);
        result = 31 * result + (isFullTime != null ? isFullTime.hashCode() : 0);
        return result;
    }
}
