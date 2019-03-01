package io.university.model.dao;


import io.dummymaker.annotation.complex.GenList;
import io.dummymaker.annotation.simple.string.GenCompany;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GenCompany
    private String name;

    private Integer sub_department_id;

    @GenList
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<WorkProgress> workProgresses;

    @GenList
    @OneToMany(mappedBy = "department")
    private List<StudyProgress> studyProgresses;

    public Long getId() {
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
