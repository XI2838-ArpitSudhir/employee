package com.example.employee.daos;

import com.example.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeDao extends MongoRepository<Employee, Long> {
}
