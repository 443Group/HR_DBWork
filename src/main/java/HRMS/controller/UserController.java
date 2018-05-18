package HRMS.controller;

import HRMS.entity.Employee;
import HRMS.repository.EmployeeRepository;
import HRMS.repository.EmployeeViewRepository;
import HRMS.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeViewRepository employeeViewRepository;

    @GetMapping(value = "/name")
    public String getUserName(Principal principal){
        Optional<Employee> employee = employeeRepository.findById(Long.valueOf(principal.getName()));
        if (employee.isPresent()){
            return employee.get().getName();
        }
        return "";
    }

    @GetMapping(value = "/info")
    public EmployeeView getUserInfo(@RequestParam(value = "id",required = false) Long id, Principal principal){
        if(id != null){
            System.out.println("ALOHA :"+id);
            Optional<EmployeeView> employeeView = employeeViewRepository.findById(id);
            return employeeView.orElseGet(EmployeeView::new);
        }else {
            Optional<EmployeeView> employeeView = employeeViewRepository.findById(Long.valueOf(principal.getName()));
            return employeeView.orElseGet(EmployeeView::new);
        }
    }


}
