package com.visu.springdataonetoonemapping.repository;

import com.visu.springdataonetoonemapping.model.Employee;
import com.visu.springdataonetoonemapping.model.EmployeeId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId> {
    List<Employee> findByEmployeeIdDepartmentId(Long departmentId);
}
