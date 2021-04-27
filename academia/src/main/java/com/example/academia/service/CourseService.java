package com.example.academia.service;
import com.example.academia.bean.Employees;
import com.example.academia.dao.implementation.CourseDaoImpl;
import com.example.academia.bean.Courses;

import java.util.List;


public class CourseService {
    CourseDaoImpl courseDoa = new CourseDaoImpl();

    public Courses getCourseDetailsById(Integer course_id) {
        return courseDoa.getCourseDetailsById(course_id);
    }
    public List<Courses> getCourses() {
            return courseDoa.getCourses();

    }
    public List<Courses> getCoursesbyEmpId(Employees emp) {
        return courseDoa.getCoursesbyEmpId(emp);

    }
}
