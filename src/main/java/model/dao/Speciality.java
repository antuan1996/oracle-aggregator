package model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Speciality {

    @Id @GeneratedValue private int id;

    private int code;
    private String type;
    private String course;
    private String qualification;

    @OneToMany(mappedBy = "speciality") private List<Subject> subjects;

    @OneToMany(mappedBy = "speciality")
    private StudyProgress studyProgress;
}
