package HRMS.view;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Immutable
@Table(name = "view_emp_info")
public class EmployeeView {
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

    @Column(name= "dep_name")
    private
    String departmentName;

    @Column(name= "title_name")
    private
    String titleName;

    private String email;

    @Column(name= "phone_number")
    private
    String phoneNumber;

    private LocalDate birthday;

    @Column(name= "time_register")
    private
    LocalDateTime registerTime;

    @Column(name= "political_value")
    private
    String politicalValue;

    @Column(name= "health_value")
    private
    String healthValue;

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getPostName() {
        return postName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public String getPoliticalValue() {
        return politicalValue;
    }

    public String getHealthValue() {
        return healthValue;
    }
}
