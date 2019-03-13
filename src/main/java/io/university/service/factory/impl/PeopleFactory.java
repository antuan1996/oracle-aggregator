package io.university.service.factory.impl;

import io.university.model.dao.oracle.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 01.03.2019
 */
@Service
public class PeopleFactory extends BasicFactory<Person> {

    private enum Ratio {
        DEPARTMENT(100),
        SPECIALITY(30);

        private final int value;

        Ratio(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getRatio(int n) {
            return n < value ? 1 : n / value;
        }
    }

    @Override
    public Person build() {
        return build(1).get(0);
    }

    @Override
    public List<Person> build(int n) {
        final List<Department> departments = factory.produce(Department.class, Ratio.DEPARTMENT.getRatio(n));
        final List<Speciality> specialities = factory.produce(Speciality.class, Ratio.SPECIALITY.getRatio(n));
        final List<Person> people = factory.produce(Person.class, n);

        specialities.forEach(s -> s.getSubjects().forEach(subject -> {
            subject.setSpeciality(s);
            subject.getGrades().forEach(g -> {
                final Person person = people.get(ThreadLocalRandom.current().nextInt(0, people.size() - 1));
                g.setSubject(subject);
                person.addGrade(g);
            });
        }));

        for (int i = 0; i < people.size(); i++) {
            final Person p = people.get(i);
            final Speciality speciality = specialities.get(i / Ratio.SPECIALITY.value);

            p.getStudy().setPerson(p);
            p.getStudy().setSpeciality(speciality);
            p.getWorkHistory().setPerson(p);

            final Department department = departments.get(i / Ratio.DEPARTMENT.value);
            p.getStudy().setDepartment(department);
            p.getWorkHistory().setDepartment(department);

        }

        final List<Subject> subjects = specialities.stream()
                .filter(s -> CollectionUtils.isEmpty(s.getSubjects()))
                .map(Speciality::getSubjects)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        final List<Schedule> schedules = factory.produce(Schedule.class, subjects.size());
        for (int i = 0; i < subjects.size(); i++) {
            subjects.get(i).setSchedule(schedules.get(i));
        }

        for (int i = 0; i < people.size(); i++) {
            final Person p = people.get(i);
            final Speciality speciality = specialities.get(i / Ratio.SPECIALITY.value);
            speciality.getSubjects().forEach(s -> p.addSchedule(s.getSchedule()));
        }

        return people;
    }
}
