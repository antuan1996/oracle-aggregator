package io.university.service.impl;

import io.university.model.dao.common.*;
import io.university.storage.impl.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * "default comment"
 *
 * @author GoodforGod
 * @since 11.03.2019
 */
@Service
public class CPeopleValidateStorage {

    @Autowired private CDepartmentStorage departmentStorage;
    @Autowired private CSpecialityStorage specialityStorage;
    @Autowired private CScheduleStorage scheduleStorage;
    @Autowired private CSubjectStorage subjectStorage;
    @Autowired private CPersonStorage peopleStorage;
    @Autowired private CEditionStorage editionStorage;
    @Autowired private CCommunityStorage communityStorage;

    public List<CPerson> saveUpdate(List<CPerson> people) {
        if (CollectionUtils.isEmpty(people))
            return Collections.emptyList();

        saveUpdateStudies(people);

        return people;
    }

    private void saveUpdateStudies(List<CPerson> people) {
        for (CPerson person : people) {
            if (!CollectionUtils.isEmpty(people.get(0).getGrades())) {
                for (CGrade grade : person.getGrades()) {
                    final CSubject subject = grade.getSubject();
                    if (subject != null) {
                        final CSpeciality speciality = subject.getSpeciality();
                        if (speciality != null) {
                            specialityStorage.save(speciality);
                            speciality.addSubject(subject);
                            subject.setSpeciality(speciality);
                        }

                        grade.setSubject(subject);
                        subject.addGrade(grade);
                        subjectStorage.save(subject);
                    }
                    person.addGrade(grade);
                }
            }

            final CStudy study = person.getStudy();
            if(study != null) {
                study.setPerson(person);

                final CSpeciality speciality = study.getSpeciality();
                if(speciality != null) {
                    specialityStorage.save(speciality);
                }
            }

            final Set<CSchedule> schedules = person.getSchedules();
            if(!CollectionUtils.isEmpty(schedules)) {
                for (CSchedule schedule : schedules) {
                    schedule.addPerson(person);
                    final CSubject subject = schedule.getSubject();
                    if(subject != null) {
                        subjectStorage.save(subject);
                    }
                }
            }
        }
        peopleStorage.save(people);
    }

    private <T> T randomPick(List<T> list) {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size() - 1));
    }
}
