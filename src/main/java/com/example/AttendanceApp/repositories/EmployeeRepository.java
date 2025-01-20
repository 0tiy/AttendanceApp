package com.example.AttendanceApp.repositories;

import com.example.AttendanceApp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByFirstNameAndLastName(
            String firstName,
            String lastName
    );

}
