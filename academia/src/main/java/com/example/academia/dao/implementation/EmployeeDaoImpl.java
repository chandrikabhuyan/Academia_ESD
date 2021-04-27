package com.example.academia.dao.implementation;

import com.example.academia.bean.CourseSchedule;
import com.example.academia.bean.Courses;
import com.example.academia.bean.Employees;
import com.example.academia.dao.EmployeeDao;
import com.example.academia.utils.SessionUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {
    Session session = SessionUtil.getSession();

    @Override
    public Employees login(Employees emp) {

        try {
            Query query = session.createQuery("from Employees where email=:email and password=:password");
            query.setParameter("email", emp.getEmail());
            query.setParameter("password", emp.getPassword());
            Employees e = null;
            if (query.getResultList().size() == 1)
                e = (Employees) query.list().get(0);
            return e;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        } finally {
            session.close();
        }
        return new Employees();
    }

    @Override
    public boolean addEmployee(Employees employee) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Employees getEmployeeDetailsById(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Employees.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }


    @Override
    public boolean registerEmployee(Integer employee_id, Integer course_id) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            Employees emp = new Employees();
            session.load(emp, employee_id);
            CourseDaoImpl courseDaoimpl = new CourseDaoImpl();
            List<Courses> courses = courseDaoimpl.getCoursesbyEmpId(emp);
            for (Courses course : courses)
                System.out.println(courses);
            Courses cou = new Courses();
            session.load(cou, course_id);

            for (Courses course : courses) {
                Query query1 = session.createQuery("from CourseSchedule where course_id=:x");
                query1.setParameter("x", cou);
                Query query2 = session.createQuery("from CourseSchedule where course_id =:y");
                query2.setParameter("y", course);
                CourseSchedule c1 = (CourseSchedule) query1.getResultList().get(0);
                CourseSchedule c2 = (CourseSchedule) query2.getResultList().get(0);
                if (c1.getDay().equals(c2.getDay()) && c1.getTime().equals(c2.getTime())) {
                    return false;
                } /*else {
                    cou.setEmployee_id(getEmployeeDetailsById(employee_id));
                    session.update(cou);
                    transaction.commit();
                    return true;
                }*/
            }
            cou.setEmployee_id(getEmployeeDetailsById(employee_id));
            session.update(cou);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        finally {
            session.close();
        }
       return false;
    }

}