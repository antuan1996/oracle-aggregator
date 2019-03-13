package io.university.controller.oracle;

import io.university.model.dao.oracle.Person;
import io.university.service.factory.impl.PeopleFactory;
import io.university.storage.impl.oracle.PersonStorage;
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
 * @since 01.03.2019
 */
@RestController
public class PeopleController {

    @Autowired private PersonStorage peopleStorage;
    @Autowired private PeopleFactory factory;

    @GetMapping("/oracle/all")
    public List<Person> getAll() {
        return peopleStorage.findAll();
    }

    @GetMapping("/oracle/fill/{amount}")
    public List<Person> fillWithPeople(@PathVariable(name = "amount", required = false) Integer amount) {
        final int genAmount = (amount != null && amount > 0)
                ? amount
                : ThreadLocalRandom.current().nextInt(2, 4);

        final List<Person> people = factory.build(genAmount);
        peopleStorage.save(people);
        return people.subList(0, 1);
    }
}
