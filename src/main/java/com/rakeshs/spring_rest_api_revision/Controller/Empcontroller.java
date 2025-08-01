package com.rakeshs.spring_rest_api_revision.Controller;

import com.rakeshs.spring_rest_api_revision.Entity.Employee;
import com.rakeshs.spring_rest_api_revision.Service.Empservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Empcontroller {


    private final Empservice empservice;

    public Empcontroller(Empservice empservice) {
        this.empservice = empservice;
    }

    @GetMapping("/health-check")
    public String healthcheck(){
     return "OK";
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = empservice.postEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

}
