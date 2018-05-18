package HRMS.repository;

import HRMS.view.EmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeViewRepository extends JpaRepository<EmployeeView,Long> {
    public List<EmployeeView> findByDepartmentName(String depName);
}
