package com.yws.controller;

import com.yws.bean.Department;
import com.yws.bean.Employee;
import com.yws.mapper.DepartmentMapper;
import com.yws.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department department(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }


    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

}
