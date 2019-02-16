package model.dao;

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

    private short course;
    private String group;
    private Timestamp start_timestamp;
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
}
