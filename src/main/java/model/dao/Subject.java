package model.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Subject {

    @Id @GeneratedValue private int id;

    private int code;
    private String name;
    private String semester;
    private Timestamp start_timestamp;
    private Timestamp end_timestamp;

    @OneToOne(mappedBy = "subject") private Schedule schedule;
    @OneToMany(mappedBy = "subject") private List<Grade> grades;

    @ManyToOne
    @JoinColumn(name="speciality_id")
    private Speciality speciality;
}

