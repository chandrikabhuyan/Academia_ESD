package com.example.academia.utils;

import com.example.academia.bean.Employees;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

  public class SessionUtil {
        private static final SessionFactory ourSessionFactory;

        static {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();

                ourSessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static Session getSession() throws HibernateException {
            return ourSessionFactory.openSession();
        }

   /* public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
           Employees employee = new Employees();
           employee.setEmail("abc@iiitb.org");
            employee.setPassword("123");
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

       } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());   }
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
               final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    } */
    }