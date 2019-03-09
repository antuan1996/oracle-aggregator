package io.university.controller;

import io.university.model.dao.common.CPerson;
import io.university.service.impl.CPeopleFactory;
import io.university.storage.impl.common.CPersonStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 10.03.2019
 */
@RestController
public class CPeopleController {

    @Autowired private CPersonStorage storage;
    @Autowired private CPeopleFactory factory;

    @GetMapping("/common/all")
    public List<CPerson> getAll() {
        return storage.findAll();
    }

}
