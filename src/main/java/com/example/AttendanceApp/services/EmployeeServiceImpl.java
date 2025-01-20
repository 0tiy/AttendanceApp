package com.example.AttendanceApp.services;

import com.example.AttendanceApp.models.Employee;
import com.example.AttendanceApp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
       return employeeRepository.findById(id).orElseThrow(
               () -> new IllegalArgumentException(String.format("Location with id (%s) not found.", id))
       );
    }

    @Override
    public boolean employeeExist(String firstName, String lastname) {
        return employeeRepository.existsByFirstNameAndLastName(firstName, lastname);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Employee> employees = employeeRepository.findById(id);
        if (employees.isPresent()){
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public void updateEmployeeById(long id) {
        Optional<Employee> employees = employeeRepository.findById(id);
        if (employees.isPresent()){
            Employee e = employees.get();
        }
    }
}
