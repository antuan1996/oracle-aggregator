package model.dao;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.number.GenShort;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class StudyProgress {

    @Id @GeneratedValue private int id;

    @GenShort
    private short course;
    @GenShort
    private String group;
    @GenTime
    private Timestamp start_timestamp;
    @GenTime
    private Timestamp graduate_timestamp;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public short getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public Timestamp getStart_timestamp() {
        return start_timestamp;
    }

    public Timestamp getGraduate_timestamp() {
        return graduate_timestamp;
    }

    public Department getDepartment() {
        return department;
    }

    public Person getPerson() {
        return person;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}
