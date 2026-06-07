package org.premanshuray.EmployeeManagementSystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name= "employees")
@Getter
@Setter
public class EmployeeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String role;
    private Double salary;
    private LocalDate dateOfJoining;
    private boolean isActive;
}