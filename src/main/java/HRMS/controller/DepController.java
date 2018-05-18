package HRMS.controller;

import HRMS.entity.Department;
import HRMS.repository.DepartmentRepository;
import HRMS.repository.DepartmentViewRepository;
import HRMS.repository.PostingRepository;
import HRMS.view.DepartmentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepController {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentViewRepository departmentViewRepository;

    @Autowired
    PostingRepository postingRepository;

    @GetMapping(value = "/list")
    public List<DepartmentView> getAll(){
        return departmentViewRepository.findAll();
    }

    @GetMapping(value = "/number")
    public Long getNumber(@RequestParam(value = "id") Long depId){
        return postingRepository.countByDepId(depId);
    }
/*    @GetMapping(value = "/info")
    public Department getUserInfo(@RequestParam(value = "id") Long id){
        if(id != null){
            System.out.println("ALOHA :"+id);
            Optional<EmployeeView> employeeView = employeeViewRepository.findById(id);
            return employeeView.orElseGet(EmployeeView::new);
        }else {
            Optional<EmployeeView> employeeView = employeeViewRepository.findById(Long.valueOf(principal.getName()));
            return employeeView.orElseGet(EmployeeView::new);
        }
    }*/
}
