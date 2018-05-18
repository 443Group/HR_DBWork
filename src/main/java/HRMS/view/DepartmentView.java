package HRMS.view;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "view_emp_info")
public class DepartmentView {
    @Id
    @Column(name= "dep_id")
    private Integer depId;

    @Column(name= "dep_name")
    private String depName;

    @Column(name= "mgr_name")
    private String mgrName;

    @Column(name = "dep_number")
    private String phoneNumber;

    private String addr;

    private String info;

    @Column(name= "parent_dep_name")
    private String parentName;

    public Integer getDepId() {
        return depId;
    }

    public String getDepName() {
        return depName;
    }

    public String getMgrName() {
        return mgrName;
    }

    public String getAddr() {
        return addr;
    }

    public String getInfo() {
        return info;
    }

    public String getParentName() {
        return parentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
