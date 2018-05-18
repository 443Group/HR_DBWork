package HRMS.view;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "view_emp_salary")
public class SalaryView {
    @Id
    @Column(name= "emp_id")
    private
    Long employeeId;

    @Column(name= "emp_name")
    private
    String employeeName;

    @Column(name= "post_name")
    private
    String postName;

    @Column(name= "post_salary_month")
    private
    Long monthlySalary;

    @Column(name= "year_bonus")
    private
    String annualBonus;

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getPostName() {
        return postName;
    }

    public Long getMonthlySalary() {
        return monthlySalary;
    }

    public String getAnnualBonus() {
        return annualBonus;
    }
}
