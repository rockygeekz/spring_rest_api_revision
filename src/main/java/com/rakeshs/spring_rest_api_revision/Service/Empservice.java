package com.rakeshs.spring_rest_api_revision.Service;

import com.rakeshs.spring_rest_api_revision.Entity.Employee;
import com.rakeshs.spring_rest_api_revision.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Empservice {
    private final EmployeeRepository employeeRepository;


    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }


    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setName(updatedEmployee.getName());
                    existingEmployee.setEmail(updatedEmployee.getEmail());
                    existingEmployee.setDepartment(updatedEmployee.getDepartment());
                    // Add any other fields to update
                    return employeeRepository.save(existingEmployee);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));
    }


//    public Employee updateEmployee(Long id, Employee employee) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//
//        if (optionalEmployee.isPresent()) {
//            Employee existingEmployee = optionalEmployee.get();
//
//            existingEmployee.setEmail(employee.getEmail());
//            existingEmployee.setName(employee.getName());
//            existingEmployee.setPhone(employee.getPhone());
//            existingEmployee.setDepartment(employee.getDepartment());
//
//            return employeeRepository.save(existingEmployee);
//        }
//
//        return null;
    }





