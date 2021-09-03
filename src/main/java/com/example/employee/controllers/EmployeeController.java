package com.example.employee.controllers;

import com.example.employee.models.Employee;
import com.example.employee.sevices.EmployeeService;
import com.example.employee.sevices.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @Autowired
    NextSequenceService nextSequenceService;

    @GetMapping("/getEmployee")
    public List<Employee> getEmployeeList(){
        return service.getEmployeeList();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id){
        return service.findEmployeeById(id);
    }

    @PostMapping("/addEmployee")
    public String addEmployeeToList(@RequestBody Employee employee){
        employee.setId(nextSequenceService.getNextSequence("employee_sequence"));
        service.insertEmployee(employee);
        return "Employee added successfully with id " + employee.getId();
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(@PathVariable("id") long id){
        service.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        service.updateList(employee);
    }

}
