package io.university.service.impl;

import io.dummymaker.factory.impl.GenProduceFactory;
import io.university.model.dao.common.*;
import io.university.service.IFactory;
import io.university.storage.impl.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 05.03.2019
 */
@Component
public class CPeopleFactory implements IFactory<CPerson> {

    private final GenProduceFactory factory = new GenProduceFactory();

    private final CDepartmentStorage departmentStorage;
    private final CSpecialityStorage specialityStorage;
    private final CScheduleStorage scheduleStorage;
    private final CSubjectStorage subjectStorage;
    private final CPersonStorage peopleStorage;
    private final CEditionStorage editionStorage;

    private static final int DEPARTMENT_RATIO = 100;
    private static final int CONFERENCE_RATIO = 60;
    private static final int EDITION_RATIO = 50;
    private static final int PROJECT_RATIO = 40;
    private static final int BOOKS_RATIO = 40;
    private static final int SPECIALITY_RATIO = 30;

    @Autowired
    public CPeopleFactory(CDepartmentStorage departmentStorage,
                          CSubjectStorage subjectStorage,
                          CSpecialityStorage specialityStorage,
                          CPersonStorage peopleStorage,
                          CScheduleStorage scheduleStorage,
                          CEditionStorage editionStorage) {
        this.departmentStorage = departmentStorage;
        this.subjectStorage = subjectStorage;
        this.specialityStorage = specialityStorage;
        this.peopleStorage = peopleStorage;
        this.scheduleStorage = scheduleStorage;
        this.editionStorage = editionStorage;
    }

    @Override
    public CPerson build() {
        return build(1).get(0);
    }

    @Override
    public List<CPerson> build(int n) {
        final int depNum = (n < DEPARTMENT_RATIO) ? 1 : n / DEPARTMENT_RATIO;
        final int specNum = (n < SPECIALITY_RATIO) ? 1 : n / SPECIALITY_RATIO;
        final int projNum = (n < PROJECT_RATIO) ? 1 : n / PROJECT_RATIO;
        final int bookNum = (n < BOOKS_RATIO) ? 1 : n / BOOKS_RATIO;
        final int editNum = (n < EDITION_RATIO) ? 1 : n / EDITION_RATIO;
        final int confNum = (n < CONFERENCE_RATIO) ? 1 : n / CONFERENCE_RATIO;

        final List<CDepartment> departments = factory.produce(CDepartment.class, depNum);
        final List<CSpeciality> specialities = factory.produce(CSpeciality.class, specNum);
        final List<CPerson> people = factory.produce(CPerson.class, n);

        specialities.forEach(s -> s.getSubjects().forEach(subject -> {
            subject.setSpeciality(s);
            subject.getGrades().forEach(g -> {
                final CPerson person = randomPick(people);
                g.setSubject(subject);
                person.addGrade(g);
            });
        }));
        specialityStorage.save(specialities);
        departmentStorage.save(departments);

        for (int i = 0; i < people.size(); i++) {
            final CPerson p = people.get(i);
            final CSpeciality speciality = specialities.get(i / SPECIALITY_RATIO);

            p.getStudy().setPerson(p);
            p.getStudy().setSpeciality(speciality);
            p.getWorkHistory().setPerson(p);

            final CDepartment department = departments.get(i / DEPARTMENT_RATIO);
            p.getStudy().setDepartment(department);
            p.getWorkHistory().setDepartment(department);

        }
        peopleStorage.save(people);

        final List<CSubject> subjects = subjectStorage.findAll();
        final List<CSchedule> schedules = factory.produce(CSchedule.class, subjects.size());
        for (int i = 0; i < subjects.size(); i++) {
            subjects.get(i).setSchedule(schedules.get(i));
        }

        for (int i = 0; i < people.size(); i++) {
            final CPerson p = people.get(i);
            final CSpeciality speciality = specialities.get(i / SPECIALITY_RATIO);
            speciality.getSubjects().forEach(s -> p.addSchedule(s.getSchedule()));
        }
        scheduleStorage.save(schedules);
        peopleStorage.save(people);

        final List<CConference> conferences = factory.produce(CConference.class, confNum);
        for (CConference conference : conferences) {
            final CPerson person = randomPick(people);
            person.addConference(conference);
        }
        peopleStorage.save(people);

        final List<CBook> books = factory.produce(CBook.class, bookNum);
        for (CBook book : books) {
            for (CReading reading : book.getReadings()) {
                final CPerson person = randomPick(people);
                reading.setBook(book);
                person.addReading(reading);
                reading.setPerson(person);
            }
        }
        peopleStorage.save(people);

        final List<CProject> projects = factory.produce(CProject.class, projNum);
        for (CProject project : projects) {
            for (CProjectParticipation participation : project.getParticipations()) {
                final CPerson person = randomPick(people);
                participation.setProject(project);
                person.addParticipation(participation);
                participation.setPerson(person);
            }
        }
        peopleStorage.save(people);

        final List<CEdition> editions = factory.produce(CEdition.class, editNum);
        editionStorage.save(editions);
        for (CEdition edition : editions) {
            for (CPublishment publishment : edition.getPublishments()) {
                final CPerson person = randomPick(people);
                publishment.addEdition(edition);
                publishment.setPerson(person);
                person.addPublishment(publishment);
            }
        }
        editionStorage.save(editions);
        peopleStorage.save(people);

        return people;
    }

    private <T> T randomPick(List<T> list) {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size() - 1));
    }
}
