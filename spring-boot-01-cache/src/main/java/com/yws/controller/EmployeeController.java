package com.yws.controller;

import com.yws.bean.Employee;
import com.yws.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmp(id);
        return emp;
    }


    @GetMapping("/emp")
    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmployeeByLastName(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }
}
