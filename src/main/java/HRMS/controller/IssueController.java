package HRMS.controller;

import HRMS.entity.Employee;
import HRMS.entity.Issue;
import HRMS.repository.EmployeeRepository;
import HRMS.repository.IssueRepository;
import HRMS.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RequestMapping("/issue")
@Controller
public class IssueController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    IssueRepository issueRepository;

    @PostMapping("/submit")
    public String submit(@RequestParam("type") Integer type,
                          @RequestParam("subject") String subject,
                          @RequestParam("phone") String contact,
                          @RequestParam(value = "editor1", required = false) String content,
                          Principal principal
                          ){
        Optional<Employee> employeeView = employeeRepository.findById(Long.valueOf(principal.getName()));
        Issue issue = new Issue();
        issue.setEmpId(employeeView.get().getId());
        issue.setName(employeeView.get().getName());
        issue.setType(type);
        issue.setSubject(subject);
        issue.setContact(contact);
        issue.setContent(content);
        issue.setStatus(45);
        issueRepository.save(issue);
        return "redirect:/success.html";
    }
}
