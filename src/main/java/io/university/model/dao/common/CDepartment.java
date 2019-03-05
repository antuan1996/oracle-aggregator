package io.university.model.dao.common;

import io.dummymaker.annotation.simple.string.GenCompany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 05.03.2019
 */
@Entity
@Table(schema = "sys")
public class CDepartment implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @GenCompany
    private String name;

    private Integer subDepartmentId;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<CWorkHistory> workHistories = new ArrayList<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<CStudy> studies = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSubDepartmentId() {
        return subDepartmentId;
    }

    public CWorkHistory addWorkHistory(CWorkHistory workHistory) {
        this.workHistories.add(workHistory);
        return workHistory;
    }

    public CStudy addStudy(CStudy study) {
        this.studies.add(study);
        return study;
    }

    public List<CWorkHistory> getWorkHistories() {
        return workHistories;
    }

    public List<CStudy> getStudies() {
        return studies;
    }
}
