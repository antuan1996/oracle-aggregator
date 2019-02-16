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
public class WorkProgress {

    @Id @GeneratedValue private int id;

    private Timestamp start_timestamp;
    private Timestamp end_timestamp;
    private String position;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
