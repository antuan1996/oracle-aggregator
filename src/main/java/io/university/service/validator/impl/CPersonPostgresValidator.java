package io.university.service.validator.impl;

import io.university.model.dao.common.CPerson;
import io.university.service.validator.IValidator;
import org.springframework.stereotype.Service;

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

    @Override
    public List<CPerson> validate(List<CPerson> people) {

        return Collections.emptyList();
    }
}
