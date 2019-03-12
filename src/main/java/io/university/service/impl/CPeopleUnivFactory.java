package io.university.service.impl;

import io.dummymaker.factory.impl.GenProduceFactory;
import io.university.model.dao.common.*;
import io.university.storage.impl.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 12.03.2019
 */
@Service
public class CPeopleUnivFactory extends BasicFactory<CPerson> {

    private final GenProduceFactory factory = new GenProduceFactory();

    @Autowired
    private CDepartmentStorage departmentStorage;
    @Autowired
    private CSpecialityStorage specialityStorage;
    @Autowired
    private CScheduleStorage scheduleStorage;
    @Autowired
    private CSubjectStorage subjectStorage;
    @Autowired
    private CPersonStorage peopleStorage;
    @Autowired
    private CEditionStorage editionStorage;
    @Autowired
    private CCommunityStorage communityStorage;

    private static final int DEPARTMENT_RATIO = 100;
    private static final int CONFERENCE_RATIO = 40;
    private static final int EDITION_RATIO = 50;
    private static final int PROJECT_RATIO = 40;
    private static final int BOOKS_RATIO = 40;
    private static final int COMMUNITY_RATIO = 30;
    private static final int SPECIALITY_RATIO = 30;

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
        final int commNum = (n < COMMUNITY_RATIO) ? 1 : n / COMMUNITY_RATIO;

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

        final List<CSubject> subjects = subjectStorage.findAll();
        final List<CSchedule> schedules = factory.produce(CSchedule.class, subjects.size());
        for (int i = 0; i < subjects.size(); i++) {
            final CSchedule schedule = schedules.get(i);
            subjects.get(i).setSchedule(schedule);
            schedule.setSubject(subjects.get(i));
        }
        scheduleStorage.save(schedules);

        final List<CSpeciality> cSpecialities = specialityStorage.findAll();
        for (int i = 0; i < people.size(); i++) {
            final CPerson p = people.get(i);
            final CSpeciality speciality = cSpecialities.get(i / SPECIALITY_RATIO);
            speciality.getSubjects().stream()
                    .filter(s -> s.getSchedule() != null)
                    .forEach(s -> p.addSchedule(s.getSchedule()));
        }

        final List<CConference> conferences = factory.produce(CConference.class, confNum);
        for (CConference conference : conferences) {
            final CPerson person = randomPick(people);
            person.addConference(conference);
        }

        final List<CBook> books = factory.produce(CBook.class, bookNum);
        for (CBook book : books) {
            for (CReading reading : book.getReadings()) {
                final CPerson person = randomPick(people);
                reading.setBook(book);
                person.addReading(reading);
                reading.setPerson(person);
            }
        }

        final List<CProject> projects = factory.produce(CProject.class, projNum);
        for (CProject project : projects) {
            for (CProjectParticipation participation : project.getParticipations()) {
                final CPerson person = randomPick(people);
                participation.setProject(project);
                person.addParticipation(participation);
                participation.setPerson(person);
            }
        }

        final List<CEdition> editions = factory.produce(CEdition.class, editNum);
        for (CEdition edition : editions) {
            for (CPublishment publishment : edition.getPublishments()) {
                final CPerson person = randomPick(people);
                publishment.addEdition(edition);
                publishment.setPerson(person);
                person.addPublishment(publishment);
            }
        }

        final List<CCommunity> communities = factory.produce(CCommunity.class, commNum);
        for (CCommunity community : communities) {
            for (CRoom room : community.getRooms()) {
                room.setCommunity(community);
                for (CLiving living : room.getLivings()) {
                    final CPerson person = randomPick(people);
                    living.setPerson(person);
                    living.setRoom(room);
                    person.addLiving(living);
                }
            }

            for (CVisit visit : community.getVisits()) {
                final CPerson person = randomPick(people);
                visit.setPerson(person);
                visit.setCommunity(community);
                person.addVisit(visit);
            }
        }
        communityStorage.save(communities);
        peopleStorage.save(people);

        return people;
    }
}
