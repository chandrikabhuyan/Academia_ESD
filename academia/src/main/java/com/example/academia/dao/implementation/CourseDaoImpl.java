package com.example.academia.dao.implementation;
import com.example.academia.bean.Courses;
import com.example.academia.bean.Employees;
import com.example.academia.dao.CourseDao;
import com.example.academia.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    Session session = SessionUtil.getSession();

    @Override
    public boolean registerCourse(Courses course) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Courses getCourseDetailsById(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Courses.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Courses> getCourses() {
            Session session = SessionUtil.getSession();
            List<Courses> courses = new ArrayList<>();
            try {
                for (final Object course : session.createQuery("from Courses ").list()) {
                    courses.add((Courses) course);
                }
            } catch (HibernateException exception) {
                System.out.print(exception.getLocalizedMessage());
            }
            return courses;
        }

//    @Override
//    public List<Courses> getCoursesbyEmpId(Employees emp) {
//        Session session = SessionUtil.getSession();
//        List<Courses> courses = new ArrayList<>();
//        try {
//
//            for (final Object course : session.createQuery("from Courses where Employees =: emp ").list()) {
//                courses.add((Courses) course);
//            }
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//        }
//        return courses;
//    }
    @Override
    public  List<Courses> getCoursesbyEmpId(Employees emp) {
        Session session = SessionUtil.getSession();
        List<Courses> courses = new ArrayList<>();
        try {
            Query query = session.createQuery("from Courses where employee_id =: emp ");
            query.setParameter("emp",emp);
            courses.addAll(query.getResultList());
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return courses;
    }


}


