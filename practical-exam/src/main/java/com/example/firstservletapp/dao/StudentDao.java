package com.example.firstservletapp.dao;

import com.example.firstservletapp.entity.Employee;
import com.example.firstservletapp.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class StudentDao {
    Session session;

    public StudentDao() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<Employee> studentList() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            List<Employee> list = session.createQuery("FROM Employee").getResultList();
            return list;
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public Employee createOrUpdate(Employee employee) {
        try {
            session.beginTransaction();
            if (employee.getId() == null) {
                session.save(employee);
            } else {
                session.update(employee);
            }
            session.getTransaction().commit();

            return employee;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            System.out.println(ex);
        }
        return null;
    }
}
