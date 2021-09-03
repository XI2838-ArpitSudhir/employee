package com.example.employee.services;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.employee.daos.EmployeeDao;
import com.example.employee.models.Employee;
import com.example.employee.sevices.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest {
	
    @Mock
    EmployeeDao dao;
   
    @InjectMocks
    EmployeeService service;
   
    @Test
    public void testAddEmployee() {​​​​​​​
        Employee employee = new Employee();
        when(dao.save(employee)).thenReturn(employee);
        service.insertEmployee(employee);
        Mockito.verify(dao).save(Mockito.any(Employee.class));
    }​​​​​​​


}
