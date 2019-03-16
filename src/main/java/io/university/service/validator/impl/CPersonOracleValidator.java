package io.university.service.validator.impl;

import io.university.model.dao.common.*;
import io.university.service.validator.IValidator;
import io.university.storage.impl.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired private CStudyStorage studyStorage;

    @Override
    public List<CPerson> validate(List<CPerson> people) {
        if (CollectionUtils.isEmpty(people))
            return Collections.emptyList();

        final Map<Integer, CDepartment> departmentMap = new HashMap<>();
        final Map<Integer, CSpeciality> specialityMap = new HashMap<>();
        final Map<Integer, CSubject> subjectMap = new HashMap<>();
        final Map<Integer, CStudy> studyMap = new HashMap<>();

        for (CPerson p : people) {
            if (p.getStudy() != null) {
                CStudy study = studyMap.computeIfAbsent(p.getStudy().hashCode(),
                        (k) -> studyStorage.find(p.getStudy().getId()).orElse(p.getStudy()));

                if (study.getDepartment() != null) {
                    CDepartment department = departmentMap.computeIfAbsent(study.getDepartment().hashCode(),
                            (k) -> departmentStorage.find(study.getDepartment().getId()).orElse(study.getDepartment()));
                    study.setDepartment(department);
                }

                if (study.getSpeciality() != null) {
                    CSpeciality speciality = getSpeciality(study.getSpeciality(), specialityMap);
                    fillStudy(speciality, studyMap);
                    study.setSpeciality(speciality);
                }

                p.setStudy(study);
            }

            CWorkHistory history = p.getWorkHistory();
            if (history != null) {
                if (history.getDepartment() != null) {
                    CDepartment department = departmentMap.computeIfAbsent(history.getDepartment().hashCode(),
                            (k) -> departmentStorage.find(history.getDepartment().getId()).orElse(history.getDepartment()));
                    history.setDepartment(department);
                }
            }

            if (CollectionUtils.isEmpty(p.getSchedules()))
                continue;

            for (CSchedule schedule : p.getSchedules()) {
                if (schedule.getSubject() == null)
                    continue;

                CSubject subject = subjectMap.computeIfAbsent(schedule.getSubject().hashCode(),
                        (k) -> subjectStorage.find(schedule.getSubject().getCode()).orElse(schedule.getSubject()));
                if (subject != schedule.getSubject()) {
                    subject.getGrades().addAll(schedule.getSubject().getGrades());
                }

                if (subject.getSpeciality() != null) {
                    CSpeciality speciality = getSpeciality(subject.getSpeciality(), specialityMap);
                    fillStudy(speciality, studyMap);
                    subject.setSpeciality(speciality);
                }
            }
        }

        return people;
    }

    private CSpeciality getSpeciality(CSpeciality speciality,
                                      Map<Integer, CSpeciality> specialityMap) {
        return specialityMap.computeIfAbsent(
                speciality.hashCode(),
                (k) -> specialityStorage.find(speciality.getCode()).orElse(speciality));
    }

    private void fillStudy(CSpeciality speciality,
                           Map<Integer, CStudy> studyMap) {
        if (speciality.getStudy() != null) {
            CStudy cStudy = studyMap.computeIfAbsent(speciality.getStudy().hashCode(), (k) -> speciality.getStudy());
            speciality.setStudy(cStudy);
        }
    }
}
