package io.university.service.validator.impl;

import io.university.model.dao.common.*;
import io.university.service.validator.IValidator;
import io.university.storage.impl.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 13.03.2019
 */
@Service
public class CPersonOracleValidator implements IValidator<CPerson> {

    @Autowired private CDepartmentStorage departmentStorage;
    @Autowired private CSpecialityStorage specialityStorage;
    @Autowired private CScheduleStorage scheduleStorage;
    @Autowired private CSubjectStorage subjectStorage;
    @Autowired private CPersonStorage peopleStorage;

    @Override
    public List<CPerson> validate(List<CPerson> people) {
        for (CPerson person : people) {
            if (!CollectionUtils.isEmpty(people.get(0).getGrades())) {
                for (CGrade grade : person.getGrades()) {
                    final CSubject subject = grade.getSubject();
                    if (subject != null) {
                        final CSpeciality speciality = subject.getSpeciality();
                        if (speciality != null) {
                            //specialityStorage.save(speciality);
                            speciality.addSubject(subject);
                            subject.setSpeciality(speciality);
                        }

                        grade.setSubject(subject);
                        subject.addGrade(grade);
                        //specialityStorage.save(speciality);
                    }
                    person.addGrade(grade);
                }
            }

            final CStudy study = person.getStudy();
            if(study != null) {
                study.setPerson(person);

                final CSpeciality speciality = study.getSpeciality();
                if(speciality != null) {
                    //specialityStorage.save(speciality);
                }
            }

            final Set<CSchedule> schedules = person.getSchedules();
            if(!CollectionUtils.isEmpty(schedules)) {
                for (CSchedule schedule : schedules) {
                    schedule.addPerson(person);
                    final CSubject subject = schedule.getSubject();
                    if(subject != null) {
                        //specialityStorage.save(speciality);
                    }
                }
            }
        }

        return Collections.emptyList();
    }
}
