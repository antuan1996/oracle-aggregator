package io.university.service.validator.impl;

import io.university.model.dao.common.CPerson;
import io.university.service.validator.IValidator;
import io.university.storage.impl.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 13.03.2019
 */
@Service
public class CPersonPostgresValidator implements IValidator<CPerson> {

    @Autowired private CSpecialityStorage specialityStorage;
    @Autowired private CSubjectStorage subjectStorage;
    @Autowired private CPersonStorage personStorage;
    @Autowired private CStudyStorage studyStorage;
    @Autowired private CGradeStorage gradeStorage;

    @Override
    public List<CPerson> validate(List<CPerson> people) {
        if(CollectionUtils.isEmpty(people))
            return Collections.emptyList();

        //TODO Your validation logic here

        return Collections.emptyList();
    }
}
