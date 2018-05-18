package HRMS.view;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "view_com_post")
public class PostView {
    @Id
    @Column(name= "post_id")
    private Integer id;

    @Column(name= "post_name")
    private String name;

    @Column(name= "post_level")
    private Integer level;

    @Column(name= "post_salary")
    private Long salary;

    @Column(name= "post_type")
    private String type;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Long getSalary() {
        return salary;
    }

    public String getType() {
        return type;
    }
}
