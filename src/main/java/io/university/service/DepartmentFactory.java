package io.university.service;

import io.dummymaker.factory.impl.GenProduceFactory;
import model.dao.Department;
import model.dao.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 01.03.2019
 */
public class DepartmentFactory implements IFactory<Department> {

    private final GenProduceFactory factory = new GenProduceFactory();

    @Override
    public Department build() {
        final Department department = factory.produce(Department.class);
        final List<Person> people = factory.produce(Person.class, ThreadLocalRandom.current().nextInt(100, 150));
        people.forEach(p -> {
            p.getWorkProgress().setDepartment(department);
            p.getStudyProgress().setDepartment(department);
            p.getStudyProgress().setSpeciality(p.getSchedule().getSubject().getSpeciality());
        });

        return department;
    }

    @Override
    public List<Department> build(int n) {
        final List<Department> departments = new ArrayList<>(n);
        for(int i = 0; i < n; i ++)
            departments.add(build());

        return departments;
    }
}
