package com.example.academia.utils;
import com.example.academia.bean.*;
import com.example.academia.dao.*;
import com.example.academia.dao.implementation.CourseDaoImpl;
import com.example.academia.dao.implementation.CourseScheduleDaoImpl;
import com.example.academia.dao.implementation.DepartmentsDaoImpl;
import com.example.academia.dao.implementation.EmployeeDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static void main(String[] args) {

        /* System.out.println("Heyy from helper");
         populateDummyData();
         }

        public static void populateDummyData(){
            populateCourseSchedule();
            populateDepartments();
            populateEmployees();
            populateCourses();
        }


        public static void populateDepartments() {
            Departments d1 = new Departments("Computer Science & Engineering", 300);
            Departments d2 = new Departments("Electronics & Communication", 150);
            DepartmentsDao departmentsDao = new DepartmentsDaoImpl();
            departmentsDao.addDepartment(d1);
            departmentsDao.addDepartment(d2);
        }


        public static void populateEmployees() {
            DepartmentsDao deptDao = new DepartmentsDaoImpl();
            Departments d1 = deptDao.getDepartmentById(1);
            Departments d2 = deptDao.getDepartmentById(2);

            Employees e1 = new Employees("rc123","Ramanathan","Chandrashekhar","rc@iiitb.ac.in", "Prof", null, d1, null);
            Employees e2 = new Employees("dd123","Debabrata", "Das", "debabrata.das@iiitb.org", "Prof", null, d2, null);
            Employees e3 = new Employees("md123","Meenakshi","DSouza","meenakshi@iiitb.ac.in","Prof",null,d1,null);
            Employees e4 = new Employees("tb123","Thangaraju","B","b.thangaraju@iiitb.ac.in","Prof",null,d1,null);
            Employees e5 = new Employees("uk123","Uttam","Kumar","uttam@iiitb.ac.in","Prof",null,d2,null);
            Employees e6 = new Employees("123","ABC","DEF","abc@iiitb.org","Prof",null,d2,null);
            EmployeeDao employeesDao = new EmployeeDaoImpl();
            employeesDao.addEmployee(e1);
            employeesDao.addEmployee(e2);
            employeesDao.addEmployee(e3);
            employeesDao.addEmployee(e4);
            employeesDao.addEmployee(e5);
            employeesDao.addEmployee(e6);
        }

        public static void populateCourses() {
            EmployeeDao employeesDao = new EmployeeDaoImpl();
            Employees e1 = employeesDao.getEmployeeDetailsById(1);
            Employees e2 = employeesDao.getEmployeeDetailsById(2);
            Employees e3 = employeesDao.getEmployeeDetailsById(3);
            Employees e4 = employeesDao.getEmployeeDetailsById(4);

            Courses c1 = new Courses("Algorithms","Algorithms",4,1, "CS511",2020, 200, e1);
            Courses c2 = new Courses("System Software","Software Systems - I",2,1, "CS513",2020, 200,e1);
            Courses c3 = new Courses("Computer Networks-I","Basics of Computer Networks",4,1, "NC501",2020, 100, e3);
            Courses c4 = new Courses("Maths for Machine Learning","Probability",2,1, "AI512",2020, 200, e4);

            CourseDao coursesDao = new CourseDaoImpl();
            coursesDao.registerCourse(c1);
            coursesDao.registerCourse(c2);
            coursesDao.registerCourse(c3);
            coursesDao.registerCourse(c4);
        }

    public static void populateCourseSchedule() {
        CourseDao coursesDao = new CourseDaoImpl();
        Courses c1 = coursesDao.getCourseDetailsById(1);
        Courses c2 = coursesDao.getCourseDetailsById(2);
        Courses c3 = coursesDao.getCourseDetailsById(3);
        Courses c4 = coursesDao.getCourseDetailsById(4);

        CourseSchedule cs1 = new CourseSchedule("11:00:00","Wednesday",1,5,c1);
        CourseSchedule cs2 = new CourseSchedule("4:30:00","Friday",1,3,c2);
        CourseSchedule cs3 = new CourseSchedule("9:00:00","Tuesday",2,3,c3);
        CourseSchedule cs4 = new CourseSchedule("4:30:00","Friday",2,5,c4);

        CourseScheduleDao courseScheduleDao = new CourseScheduleDaoImpl();
        courseScheduleDao.addCourseSchedule(cs1);
        courseScheduleDao.addCourseSchedule(cs2);
        courseScheduleDao.addCourseSchedule(cs3);
        courseScheduleDao.addCourseSchedule(cs4);
    }

*/
    }
}

