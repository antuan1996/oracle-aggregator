package io.university.service.impl;

import io.university.model.dao.common.CGrade;
import io.university.model.dao.common.CPerson;
import io.university.storage.impl.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * "default comment"
 *
 * @author GoodforGod
 * @since 11.03.2019
 */
@Service
public class CPeopleValidateStorage {

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

    public List<CPerson> saveValid(List<CPerson> people) {
        if (CollectionUtils.isEmpty(people))
            return Collections.emptyList();

        for (CPerson person : people) {
            if (!CollectionUtils.isEmpty(people.get(0).getGrades())) {
                for (CGrade grade : person.getGrades()) {
                    if (grade.getSubject() != null) {
                        if (grade.getSubject().getSpeciality() != null) {

                        }
                    }
                }
            }
        }

        return people;
    }

    private <T> T randomPick(List<T> list) {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size() - 1));
    }
}
