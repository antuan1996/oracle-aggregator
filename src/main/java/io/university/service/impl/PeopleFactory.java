package io.university.service.impl;

import io.dummymaker.factory.impl.GenProduceFactory;
import io.university.model.dao.oracle.*;
import io.university.service.IFactory;
import io.university.storage.impl.oracle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 01.03.2019
 */
@Component
public class PeopleFactory implements IFactory<Person> {

    private final DepartmentStorage departmentStorage;
    private final SpecialityStorage specialityStorage;
    private final ScheduleStorage scheduleStorage;
    private final SubjectStorage subjectStorage;
    private final PersonStorage peopleStorage;

    private final GenProduceFactory factory = new GenProduceFactory();

    private static final int DEPARTMENT_RATIO = 100;
    private static final int SPECIALITY_RATIO = 30;

    @Autowired
    public PeopleFactory(DepartmentStorage departmentStorage,
                         SubjectStorage subjectStorage,
                         SpecialityStorage specialityStorage,
                         PersonStorage peopleStorage,
                         ScheduleStorage scheduleStorage) {
        this.departmentStorage = departmentStorage;
        this.subjectStorage = subjectStorage;
        this.specialityStorage = specialityStorage;
        this.peopleStorage = peopleStorage;
        this.scheduleStorage = scheduleStorage;
    }

    @Override
    public Person build() {
        return build(1).get(0);
    }

    @Override
    public List<Person> build(int n) {
        final int depNum = (n < DEPARTMENT_RATIO) ? 1 : n / DEPARTMENT_RATIO;
        final int specNum = (n < SPECIALITY_RATIO) ? 1 : n / SPECIALITY_RATIO;

        final List<Department> departments = factory.produce(Department.class, depNum);
        final List<Speciality> specialities = factory.produce(Speciality.class, specNum);
        final List<Person> people = factory.produce(Person.class, n);

        specialities.forEach(s -> s.getSubjects().forEach(subject -> {
            subject.setSpeciality(s);
            subject.getGrades().forEach(g -> {
                final Person person = people.get(ThreadLocalRandom.current().nextInt(0, people.size() - 1));
                g.setSubject(subject);
                person.addGrade(g);
            });
        }));
        specialityStorage.save(specialities);
        departmentStorage.save(departments);

        for (int i = 0; i < people.size(); i++) {
            final Person p = people.get(i);
            final Speciality speciality = specialities.get(i / SPECIALITY_RATIO);

            p.getStudy().setPerson(p);
            p.getStudy().setSpeciality(speciality);
            p.getWorkHistory().setPerson(p);

            final Department department = departments.get(i / DEPARTMENT_RATIO);
            p.getStudy().setDepartment(department);
            p.getWorkHistory().setDepartment(department);

        }
        peopleStorage.save(people);

        final List<Subject> subjects = subjectStorage.findAll();
        final List<Schedule> schedules = factory.produce(Schedule.class, subjects.size());
        for (int i = 0; i < subjects.size(); i++) {
            subjects.get(i).setSchedule(schedules.get(i));
        }

        for (int i = 0; i < people.size(); i++) {
            final Person p = people.get(i);
            final Speciality speciality = specialities.get(i / SPECIALITY_RATIO);
            speciality.getSubjects().forEach(s -> p.addSchedule(s.getSchedule()));
        }
        scheduleStorage.save(schedules);
        peopleStorage.save(people);

        return people;
    }
}
