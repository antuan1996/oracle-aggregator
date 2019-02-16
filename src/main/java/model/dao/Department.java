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
public class Department {

    @Id @GeneratedValue private int id;

    private String name;
    private int sub_department_id;

    @OneToMany(mappedBy = "department") private List<WorkProgress> workProgresses;
    @OneToMany(mappedBy = "department") private List<StudyProgress> studyProgresses;
}
