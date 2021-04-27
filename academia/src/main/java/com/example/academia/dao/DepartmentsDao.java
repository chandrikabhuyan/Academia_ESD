package com.example.academia.dao;
import com.example.academia.bean.Departments;

public interface DepartmentsDao {

    boolean addDepartment(Departments dept);
    Departments getDepartmentById(Integer dept_id);
}
