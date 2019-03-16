package io.university.controller.common.aggregator;

import io.swagger.annotations.ApiOperation;
import io.university.model.dao.common.CPerson;
import io.university.service.factory.impl.CPeopleFactory;
import io.university.service.validator.impl.CPersonMongoValidator;
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
@RequestMapping("/common/mongo")
public class CMongoController extends BasicDatabaseController {

    @Autowired private CPersonStorage peopleStorage;
    @Autowired private CPersonMongoValidator validator;

    @Autowired
    public CMongoController(CPeopleFactory factory) {
        super(factory);
    }

    @Override
    List<CPerson> filterOtherDatabases(final List<CPerson> list) {
        if (CollectionUtils.isEmpty(list))
            return Collections.emptyList();

        return list.stream().peek(p -> {
            p.setStudy(null);
            p.setWorkHistory(null);
            p.clearConference();
            p.clearGrades();
            p.clearParticipation();
            p.clearPublishment();
            p.clearReadings();
            p.clearSchedule();
        }).collect(Collectors.toList());
    }

    @ApiOperation(
            value = "Load emulation MongoDB",
            notes = "Emulates load operation for MongoDB"
    )
    @GetMapping("/load/test")
    public List<CPerson> testLoad() {
        final List<CPerson> people = generateAsJson(2);
        return load(people);
    }

    @ApiOperation(
            value = "Load endpoint for MongoDB",
            notes = "Load endpoint to post data for MongoDB"
    )
    @PostMapping("/load")
    public List<CPerson> load(final List<CPerson> people) {
        final List<CPerson> validated = validator.validate(people);
        return peopleStorage.save(validated);
    }
}
