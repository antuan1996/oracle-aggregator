package io.university.controller.common.aggregator;

import io.university.model.dao.common.CPerson;
import io.university.service.validator.impl.CPersonMySQLValidator;
import io.university.storage.impl.common.CPersonStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 13.03.2019
 */
@RestController
@RequestMapping("/common/mysql")
public class CMySQLController {

    @Autowired private CPersonStorage peopleStorage;
    @Autowired private CPersonMySQLValidator validator;

    @PostMapping("/load")
    public List<CPerson> load(final List<CPerson> people) {
        final List<CPerson> validated = validator.validate(people);
        return peopleStorage.save(validated);
    }
}