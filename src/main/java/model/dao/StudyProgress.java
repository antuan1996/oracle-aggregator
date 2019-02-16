package model.dao;

import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
public class StudyProgress {

    private int id;
    private int department_id;

    private short course;
    private String group;
    private Timestamp start_timestamp;
    private Timestamp graduate_timestamp;

}
