package HRMS.controller;

import HRMS.entity.Employee;
import HRMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/name")
    public String getUserName(Principal principal){
        Optional<Employee> employee = employeeRepository.findById(Long.valueOf(principal.getName()));
        if (employee.isPresent()){
            return employee.get().getName();
        }
        return "";
    }
}
