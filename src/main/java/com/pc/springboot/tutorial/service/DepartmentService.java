package com.pc.springboot.tutorial.service;

import com.pc.springboot.tutorial.entity.Department;
import com.pc.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentsById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartmentById(Long id,Department department);
}
