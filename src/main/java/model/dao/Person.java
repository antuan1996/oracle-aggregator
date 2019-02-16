package model.dao;

import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
public class Person {

    public enum PersonType {
        STUDENT,
        TEACHER
    }

    private int id;
    private int study_id;
    private int work_id;

    private String name;
    private String middle_name;
    private String surname;
    private Timestamp birth_timestamp;
    private String birth_place;
    private PersonType type;


}
