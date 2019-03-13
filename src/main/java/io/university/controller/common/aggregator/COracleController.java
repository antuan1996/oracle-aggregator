package io.university.controller.common.aggregator;

import io.university.model.dao.common.CPerson;
import io.university.service.validator.impl.CPersonMongoValidator;
import io.university.service.validator.impl.CPersonOracleValidator;
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
@RequestMapping("/common/oracle")
public class COracleController {

    @Autowired private CPersonStorage peopleStorage;
    @Autowired private CPersonOracleValidator validator;

    @PostMapping("/load")
    public List<CPerson> load(final List<CPerson> people) {
        final List<CPerson> validated = validator.validate(people);
        return peopleStorage.save(validated);
    }
}
