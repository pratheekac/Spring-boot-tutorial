package com.pc.springboot.tutorial.service;

import com.pc.springboot.tutorial.entity.Department;
import com.pc.springboot.tutorial.error.DepartmentNotFoundException;
import com.pc.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentsById(Long id) throws DepartmentNotFoundException{
        Optional<Department> department = departmentRepository.findById(id);
        if (! department.isPresent()) {
            throw new DepartmentNotFoundException("Department not found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department department1 = departmentRepository.findById(id).get();

        if (department.getDepartmentAddress() != null) {
            department1.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (department.getDepartmentName() != null) {
            department1.setDepartmentName(department.getDepartmentName());
        }
        if (department.getDepartmentCode() != null) {
            department1.setDepartmentCode(department.getDepartmentCode());
        }

        return this.departmentRepository.save(department1);
    }
}
