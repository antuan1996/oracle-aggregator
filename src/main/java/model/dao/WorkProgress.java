package model.dao;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.string.GenNick;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class WorkProgress {

    @Id @GeneratedValue private int id;

    @GenTime
    private Timestamp start_timestamp;
    @GenTime
    private Timestamp end_timestamp;
    @GenNick
    private String position;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public Timestamp getStart_timestamp() {
        return start_timestamp;
    }

    public Timestamp getEnd_timestamp() {
        return end_timestamp;
    }

    public String getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Person getPerson() {
        return person;
    }
}
