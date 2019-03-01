package model.dao;

import io.dummymaker.annotation.complex.GenTime;
import io.dummymaker.annotation.simple.string.GenCity;
import io.dummymaker.annotation.simple.string.GenName;
import io.dummymaker.annotation.special.GenEmbedded;

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

    @GenName
    private String name;
    @GenName
    private String middle_name;
    @GenName
    private String surname;
    @GenTime
    private Timestamp birth_timestamp;
    @GenCity
    private String birth_place;
    private PersonType type;

    @GenEmbedded
    @OneToOne(mappedBy = "person") private WorkProgress workProgress;
    @GenEmbedded
    @OneToOne(mappedBy = "person") private StudyProgress studyProgress;
    @GenEmbedded
    @OneToOne(mappedBy = "person") private Schedule schedule;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getSurname() {
        return surname;
    }

    public Timestamp getBirth_timestamp() {
        return birth_timestamp;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public PersonType getType() {
        return type;
    }

    public WorkProgress getWorkProgress() {
        return workProgress;
    }

    public StudyProgress getStudyProgress() {
        return studyProgress;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
