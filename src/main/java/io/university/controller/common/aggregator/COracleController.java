package io.university.controller.common.aggregator;

import io.swagger.annotations.ApiOperation;
import io.university.model.dao.common.CPerson;
import io.university.service.factory.impl.CPeopleFactory;
import io.university.service.validator.impl.CPersonOracleValidator;
import io.university.storage.impl.common.CPersonStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 13.03.2019
 */
@RestController
@RequestMapping("/common/oracle")
public class COracleController extends BasicDatabaseController {

    @Autowired private CPersonStorage peopleStorage;
    @Autowired private CPersonOracleValidator validator;

    @Autowired
    public COracleController(CPeopleFactory factory) {
        super(factory);
    }

    @Override
    List<CPerson> filterOtherDatabases(final List<CPerson> list) {
        if (CollectionUtils.isEmpty(list))
            return Collections.emptyList();

        return list.stream().peek(p -> {
            p.clearConference();
            p.clearGrades();
            p.clearLivings();
            p.clearParticipation();
            p.clearPublishment();
            p.clearReadings();
            p.clearVisits();
        }).collect(Collectors.toList());
    }

    @ApiOperation(
            value = "Load emulation Oracle",
            notes = "Emulates load operation for Oracle"
    )
    @GetMapping("/load/test")
    public List<CPerson> testLoad() {
        final List<CPerson> people = generateAsJson(2);
        return load(people);
    }

    @ApiOperation(
            value = "Load endpoint for Oracle",
            notes = "Load endpoint to post data for Oracle"
    )
    @PostMapping("/load")
    public List<CPerson> load(final List<CPerson> people) {
        final List<CPerson> validated = validator.validate(people);
        return peopleStorage.save(validated);
    }
}
