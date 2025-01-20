package com.example.AttendanceApp.controllers;


import com.example.AttendanceApp.models.Employee;
import com.example.AttendanceApp.repositories.EmployeeRepository;
import com.example.AttendanceApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee")
    public String employeePage(Model model){
        model.addAttribute("employee", employeeService.getEmployee());
        return "employee";
    }

    @GetMapping("/add-employee")
    public String getEmployeesForm(){
        return "add-employee";
    }

    @PostMapping("/add-employee")
    public String createEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName){
        System.out.println("Received Data: First Name = " + firstName + ", Last Name = " + lastName);
        Employee employee = new Employee(firstName, lastName);

        if(!employeeService.employeeExist(firstName, lastName)){
            employeeService.saveEmployee(employee);
        } else System.err.println("Employee already exists!");
        return "redirect:/employee";
    }

    @GetMapping("/about-employee/{employee}")
    public String aboutEmployeePage(Model model, @PathVariable("employee") Long employeeOrder){
        model.addAttribute("employees", employeeService.getEmployeeById(employeeOrder));
        return "about-employee";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long employeeOrder){
        employeeService.deleteById(employeeOrder);
        return "redirect:/employee";
    }
}
