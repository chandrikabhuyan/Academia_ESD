package com.example.academia.dao.implementation;

import com.example.academia.bean.Departments;
import com.example.academia.bean.Employees;
import com.example.academia.dao.DepartmentsDao;
import com.example.academia.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentsDaoImpl implements DepartmentsDao {
    @Override
    public Departments getDepartmentById(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Departments.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public boolean addDepartment(Departments dept) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(dept);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
