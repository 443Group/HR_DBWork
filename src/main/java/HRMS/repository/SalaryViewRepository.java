package HRMS.repository;

import HRMS.view.SalaryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryViewRepository extends JpaRepository<SalaryView,Long> {

}