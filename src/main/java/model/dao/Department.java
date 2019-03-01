package model.dao;


import io.dummymaker.annotation.complex.GenList;
import io.dummymaker.annotation.simple.string.GenCompany;

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
public class Department {

    @Id
    @GeneratedValue
    private int id;

    @GenCompany
    private String name;
    private int sub_department_id;

    @GenList
    @OneToMany(mappedBy = "department")
    private List<WorkProgress> workProgresses;

    @GenList
    @OneToMany(mappedBy = "department")
    private List<StudyProgress> studyProgresses;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSub_department_id() {
        return sub_department_id;
    }

    public List<WorkProgress> getWorkProgresses() {
        return workProgresses;
    }

    public List<StudyProgress> getStudyProgresses() {
        return studyProgresses;
    }
}
