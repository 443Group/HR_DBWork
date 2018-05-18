package HRMS.repository;


import HRMS.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence,Long> {
    public List<Attendence> findByEmpId(Long empId);
}