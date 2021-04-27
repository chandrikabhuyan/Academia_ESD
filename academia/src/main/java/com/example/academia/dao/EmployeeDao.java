package com.example.academia.dao;
import com.example.academia.bean.Employees;
public interface EmployeeDao {

    Employees login(Employees emp);
    boolean addEmployee(Employees emp);
    Employees getEmployeeDetailsById(Integer emp_id);

    boolean registerEmployee(Integer employee_id,Integer course_id);
}
