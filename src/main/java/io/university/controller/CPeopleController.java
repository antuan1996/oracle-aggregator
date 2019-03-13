package io.university.controller;

import io.university.model.dao.common.CPerson;
import io.university.service.impl.CPeopleFactory;
import io.university.service.impl.CPeopleGenFactory;
import io.university.service.impl.CPeopleUnivFactory;
import io.university.storage.impl.common.CPersonStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@RestController
public class CPeopleController {

    @Autowired private CPeopleGenFactory genFactory;
    @Autowired private CPeopleUnivFactory univFactory;
    @Autowired private CPeopleFactory factory;
    @Autowired private CPersonStorage peopleStorage;

    @GetMapping("/common/all")
    public List<CPerson> getAll() {
        return peopleStorage.findAll();
    }

    @GetMapping("/common/fill/{amount}")
    public List<CPerson> fillWithPeople(@PathVariable(name = "amount", required = false) Integer amount) {
        final int genAmount = (amount != null && amount > 0)
                ? amount
                : ThreadLocalRandom.current().nextInt(2, 4);

        final List<CPerson> people = genFactory.build(genAmount);
        peopleStorage.save(people);
        return people.subList(0, 1);
    }
}
