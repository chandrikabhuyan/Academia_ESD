package com.example.academia.service;
import com.example.academia.bean.Employees;
import com.example.academia.dao.implementation.EmployeeDaoImpl;


public class EmployeeService {


    EmployeeDaoImpl employeeDoa = new EmployeeDaoImpl();
    public boolean registerEmployee(Integer employee_id,Integer course_id){
        return employeeDoa.registerEmployee(employee_id,course_id);
    }
    public Employees login(Employees emp)
    {
        return employeeDoa.login(emp);
    }
    public Employees getEmployeeDetailsById(Integer emp_id) {
        return employeeDoa.getEmployeeDetailsById(emp_id);
    }

}



