package com.example.academia.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.example.academia.bean.CourseSchedule;
import com.example.academia.bean.Courses;
import com.example.academia.bean.Departments;
import com.example.academia.bean.Employees;
import com.example.academia.dao.CourseDao;
import com.example.academia.dao.CourseScheduleDao;
import com.example.academia.dao.DepartmentsDao;
import com.example.academia.dao.EmployeeDao;
import com.example.academia.dao.implementation.CourseDaoImpl;
import com.example.academia.dao.implementation.CourseScheduleDaoImpl;
import com.example.academia.dao.implementation.DepartmentsDaoImpl;
import com.example.academia.dao.implementation.EmployeeDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddingData {
    public static void main(String[] args) {
    /*   Session session=SessionUtil.getSession();
      //  String upload_path = "/home/chandrika/Documents/kakashi.jpeg";
        try {
            DepartmentsDao deptDao = new DepartmentsDaoImpl();
            Departments d1 = deptDao.getDepartmentById(1);
            Employees employee = new Employees();
            employee.setEmail("kakashi@iiitb.org");
            employee.setFirst_name("kakashi");
            employee.setLast_name("hatake");
            employee.setPassword("hk123");
            employee.setTitle("Sensei");
            employee.setPhoto("/home/chandrika/Documents/kakashi.jpeg".getBytes());
            employee.setDept_id(d1);
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (
                HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
*/


    }
}
