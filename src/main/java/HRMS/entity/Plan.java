package HRMS.entity;

import javax.persistence.*;

@Entity
@Table(name = "com_plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    @Column(name = "post_id")
    private int post;

    @Column(name = "dep_id")
    private int dep;
}
