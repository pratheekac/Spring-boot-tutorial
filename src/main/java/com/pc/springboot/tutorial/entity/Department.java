package com.pc.springboot.tutorial.entity;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Data //lombok to getters and setters (boiler plate code)
@NoArgsConstructor
@AllArgsConstructor
@Builder //when multiple properties available and object can be created using few parameters
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add department name")
    private String departmentName;

    private String departmentAddress;

    private String departmentCode;

}
