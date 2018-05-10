package HRMS.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_post")
public class PostLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_id")
    private int employee;

    @Column(name = "post_type")
    private int type;

    @Column(name = "from_post_id")
    private int fromPost;

    @Column(name = "to_post_id")
    private int toPost;

    @Column(name = "from_dep_id")
    private int fromDep;

    @Column(name = "to_dep_id")
    private int toDep;

    @Column(name = "applicant_id")
    private int applicant;

    @Column(name = "reviewer_id")
    private int reviewer;

    @Column(name = "plan_id")
    private int plan;

    @Column(name = "post_time")
    private LocalDateTime postTime;

    @Column(name = "post_info")
    private String postInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFromPost() {
        return fromPost;
    }

    public void setFromPost(int fromPost) {
        this.fromPost = fromPost;
    }

    public int getToPost() {
        return toPost;
    }

    public void setToPost(int toPost) {
        this.toPost = toPost;
    }

    public int getFromDep() {
        return fromDep;
    }

    public void setFromDep(int fromDep) {
        this.fromDep = fromDep;
    }

    public int getToDep() {
        return toDep;
    }

    public void setToDep(int toDep) {
        this.toDep = toDep;
    }

    public int getApplicant() {
        return applicant;
    }

    public void setApplicant(int applicant) {
        this.applicant = applicant;
    }

    public int getReviewer() {
        return reviewer;
    }

    public void setReviewer(int reviewer) {
        this.reviewer = reviewer;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
    }
}
