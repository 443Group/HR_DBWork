package HRMS.controller;

import HRMS.entity.Employee;
import HRMS.repository.EmployeeRepository;
import HRMS.repository.EmployeeViewRepository;
import HRMS.repository.SalaryViewRepository;
import HRMS.view.EmployeeView;
import HRMS.view.SalaryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeViewRepository employeeViewRepository;

    @Autowired
    SalaryViewRepository salaryViewRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @ResponseBody
    @GetMapping(value = "/name")
    public String getUserName(Principal principal){
        Optional<Employee> employee = employeeRepository.findById(Long.valueOf(principal.getName()));
        if (employee.isPresent()){
            return employee.get().getName();
        }
        return "";
    }

    @ResponseBody
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

    @ResponseBody
    @GetMapping(value = "/list")
    public List<EmployeeView> getUserList(@RequestParam(value = "depName") String depName){
        return employeeViewRepository.findByDepartmentName(depName);
    }

    @GetMapping("/admin/update")
    public String updateUser(Long id, String name, String password, String phoneNumber, LocalDate birthday,
                             Integer political,Integer title,Long bonus){
        Optional<Employee> user = employeeRepository.findById(id);
        if (user.isPresent()){
            Employee employee = user.get();
            employee.setName(name);
            employee.setPassword(passwordEncoder.encode(password));
            employee.setPhoneNumber(phoneNumber);
            employee.setBirthday(birthday);
            employee.setPolitical(political);
            employee.setTitle(title);
            employee.setBonus(bonus);
            employeeRepository.save(employee);
            return "redirect:/profile_admin.html?id="+id;
        }else
            return "redirect:/404.html";

    }

    @ResponseBody
    @GetMapping("/salary")
    public SalaryView getSalary(@RequestParam("id") Long id){
        return salaryViewRepository.findById(id).orElseGet(SalaryView::new);
    }




}
