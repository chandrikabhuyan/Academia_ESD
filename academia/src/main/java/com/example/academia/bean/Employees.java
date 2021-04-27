package com.example.academia.bean;
import javax.persistence.*;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;

@Entity

@Table
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String first_name;

    private String last_name;

    @Column(unique = true, nullable = false)
    private String email;

    private String title;
    @Lob
    @Column(length=1000)
    private byte[] photo;

   @ManyToOne
   private Departments dept_id;

    @OneToMany
    private List<Courses> courses;

    public Employees() {
    }

    public Employees(String password, String first_name, String last_name, String email, String title, byte[] photo, Departments dept_id, List<Courses> courses) {
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
        this.photo = photo;
        this.dept_id = dept_id;
        this.courses = courses;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Departments getDept_id() {
        return dept_id;
    }

    public void setDept_id(Departments dept_id) {
        this.dept_id = dept_id;
    }

    @JsonbTransient
    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
}