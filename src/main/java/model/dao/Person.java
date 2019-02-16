package model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Person {

    public enum PersonType {
        STUDENT,
        TEACHER
    }

    @Id @GeneratedValue private int id;

    private String name;
    private String middle_name;
    private String surname;
    private Timestamp birth_timestamp;
    private String birth_place;
    private PersonType type;

    @OneToOne(mappedBy = "person") private WorkProgress workProgress;
    @OneToOne(mappedBy = "person") private StudyProgress studyProgress;
    @OneToOne(mappedBy = "person") private Schedule schedule;
}
