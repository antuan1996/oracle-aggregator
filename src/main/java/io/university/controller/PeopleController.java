package io.university.controller;

import io.university.model.dao.Person;
import io.university.service.PeopleFactory;
import io.university.storage.impl.PersonStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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

    @Autowired private PersonStorage storage;
    @Autowired private PeopleFactory factory;

    @GetMapping("/all")
    public List<Person> getAll() {
        return storage.findAll();
    }

    @GetMapping("/fill")
    public List<Person> fillDepartmentWithPeople() {
        factory.build(ThreadLocalRandom.current().nextInt(3, 5));
        return Collections.emptyList();
    }
}