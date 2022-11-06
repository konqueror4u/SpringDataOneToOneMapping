package com.visu.springdataonetoonemapping.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee implements Serializable {

    @EmbeddedId
    private EmployeeId employeeId;

    private String name;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    public Employee() {
    }

    public Employee(EmployeeId employeeId, String name, String email, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
