package com.example.employee.sevices;

import com.example.employee.daos.EmployeeDao;
import com.example.employee.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao dao;

    public List<Employee> getEmployeeList(){
        return dao.findAll();
    }

    public void insertEmployee(Employee employee){

        Optional<Employee> optionalEmployee = dao.findAll().stream().filter(employee1 -> employee1.getEmail().equals(employee.getEmail()))
                .findAny();
        if (!optionalEmployee.isPresent()){
            dao.save(employee);
        }

    }

    public Employee findEmployeeById(long id){
        return dao.findById(id).isPresent() ? dao.findById(id).get() : null;
    }

    public void deleteEmployee(long id){
        dao.deleteById(id);
    }

    public void updateList(Employee employee){
        /*list.stream().filter(employee -> employee.getId() == id).forEach(employee -> {employee.setId(id);
        employee.setName(name);
        employee.setDepartment(department);
        employee.setEmail(email);
        employee.setSalary(salary);});*/
        /*Optional<Employee> optionalEmployee = list.stream().filter(employee -> employee.getId() == id).findFirst();
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            int index = list.indexOf(employee);
            System.out.println(list.get(index).getId() + " " + list.get(index).getName() + " " + list.get(index).getDepartment());
        }*/
        if (dao.findAll().stream().filter(employee1 -> employee1.getId() == employee.getId()).findFirst().isPresent()) {
            dao.save(employee);
        }
    }

/*    public Employee getHighestPayingEmployee(){
        dao.findAll().stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.
            }
        })
    }*/


}
