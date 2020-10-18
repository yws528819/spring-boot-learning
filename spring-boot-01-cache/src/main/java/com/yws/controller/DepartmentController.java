package com.yws.controller;

import com.yws.bean.Department;
import com.yws.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return  departmentService.getDeptById(id);
    }
}
