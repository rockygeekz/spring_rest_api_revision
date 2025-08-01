package com.rakeshs.spring_rest_api_revision.repository;

import com.rakeshs.spring_rest_api_revision.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
