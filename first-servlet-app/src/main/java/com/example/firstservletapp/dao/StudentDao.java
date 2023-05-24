package com.example.firstservletapp.dao;

import com.example.firstservletapp.entity.Student;
import com.example.firstservletapp.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class StudentDao {
    Session session;

    public StudentDao() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<Student> studentList() {
        try {
            session.beginTransaction();
            List<Student> list = session.createNativeQuery("SELECT * FROM Student").getResultList();
            return list;
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public Student createOrUpdate(Student student) {
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return student;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            System.out.println(ex);
        }
        return null;
    }
}
