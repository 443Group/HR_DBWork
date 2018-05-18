package HRMS.repository;

import HRMS.view.DepartmentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentViewRepository extends JpaRepository<DepartmentView,Integer> {
}