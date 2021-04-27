package com.example.academia.dao.implementation;
import com.example.academia.bean.CourseSchedule;
import com.example.academia.dao.CourseScheduleDao;
import com.example.academia.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseScheduleDaoImpl implements CourseScheduleDao {
    @Override
    public boolean addCourseSchedule(CourseSchedule cs){
            try (Session session = SessionUtil.getSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(cs);
                transaction.commit();
                return true;
            } catch (HibernateException exception) {
                System.out.print(exception.getLocalizedMessage());
                return false;
            }
    }
}
