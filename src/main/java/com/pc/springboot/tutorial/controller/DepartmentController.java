package com.pc.springboot.tutorial.controller;

import com.pc.springboot.tutorial.entity.Department;
import com.pc.springboot.tutorial.error.DepartmentNotFoundException;
import com.pc.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    //adding logger
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of Department Controller");
       return this.departmentService.saveDepartment(department);
    }

    @GetMapping(value = "/departments")
    public List<Department> getDepartments() {
        LOGGER.info("Inside getDep of Department Controller");
        return this.departmentService.getDepartments();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return this.departmentService.getDepartmentsById(id);
    }

    @DeleteMapping(value = "/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        LOGGER.info("Inside getDepById of Department Controller");
         this.departmentService.deleteDepartmentById(id);
        return "Department Deleted Successfully";
    }

    @PutMapping(value = "/departments/{id}")
    public Department updateDepartment(@PathVariable Long id,@RequestBody Department department) {
        LOGGER.info("Inside update Department of Department Controller");
        return this.departmentService.updateDepartmentById(id,department);
    }
}
