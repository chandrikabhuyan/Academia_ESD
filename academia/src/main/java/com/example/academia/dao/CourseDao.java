package com.example.academia.dao;
import com.example.academia.bean.Courses;
import com.example.academia.bean.Employees;

import java.util.List;

public interface CourseDao {
    boolean registerCourse(Courses course);
    Courses getCourseDetailsById(Integer course_id);
    List<Courses> getCourses();
    List<Courses> getCoursesbyEmpId(Employees emp);
}
