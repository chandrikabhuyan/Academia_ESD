package com.example.academia.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Courses implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private int credits;
    @Column(nullable = false)
    private Integer term;
    @Column(nullable = false,unique = true)
    private String course_code;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn
    private Employees employee_id;

    public Courses() {
    }

    public Courses(String name, String description, int credits, Integer term, String course_code, Integer year, Integer capacity, Employees employee_id) {
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.term = term;
        this.course_code = course_code;
        this.year = year;
        this.capacity = capacity;
        this.employee_id = employee_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Employees getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employees employee_id) {
        this.employee_id = employee_id;
    }

}