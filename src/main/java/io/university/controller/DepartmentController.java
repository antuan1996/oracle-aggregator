package io.university.controller;

import io.university.model.dao.Department;
import io.university.service.DepartmentFactory;
import io.university.storage.impl.DepartmentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 01.03.2019
 */
@RestController("/department")
public class DepartmentController {

    @Autowired
    private DepartmentStorage storage;
    private DepartmentFactory factory = new DepartmentFactory();

    @GetMapping("/all")
    public List<Department> getAll() {

    }
}
