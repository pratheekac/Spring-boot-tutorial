package com.pc.springboot.tutorial.service;

import com.pc.springboot.tutorial.entity.Department;
import com.pc.springboot.tutorial.error.DepartmentNotFoundException;
import com.pc.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                .departmentName("IT")
                .departmentAddress("Bangalore")
                .departmentCode("AB1")
                        .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(department));
    }


    @Test
    @DisplayName("get data based on valid department Id")
    //@Disabled to disable the test case
    void whenValidDepartmentIdThenDepartmentIsReturned() throws DepartmentNotFoundException {
        Long departmentId = 1L;

        Department department = departmentService.getDepartmentsById(departmentId);

        assertEquals(departmentId,department.getDepartmentId());
    }




}