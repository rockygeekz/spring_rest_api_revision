package com.rakeshs.spring_rest_api_revision.Service;

import com.rakeshs.spring_rest_api_revision.Entity.Employee;
import com.rakeshs.spring_rest_api_revision.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Empservice {
    private final EmployeeRepository employeeRepository;


    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
