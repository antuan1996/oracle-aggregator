package io.university.model.dao;


import io.dummymaker.annotation.simple.string.GenCompany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
@Table(schema = "sys")
public class Department implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenCompany
    private String name;

    private Integer subDepartmentId;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<WorkHistory> workHistories = new ArrayList<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Study> studies = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSubDepartmentId() {
        return subDepartmentId;
    }

    public WorkHistory addWorkHistory(WorkHistory workHistory) {
        this.workHistories.add(workHistory);
        return workHistory;
    }

    public Study addStudy(Study study) {
        this.studies.add(study);
        return study;
    }

    public List<WorkHistory> getWorkHistories() {
        return workHistories;
    }

    public List<Study> getStudies() {
        return studies;
    }
}
