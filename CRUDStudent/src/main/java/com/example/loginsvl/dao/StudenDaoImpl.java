package com.example.loginsvl.dao;

import antlr.StringUtils;
import com.example.loginsvl.entity.Student;
import com.example.loginsvl.exception.CheckedException;
import com.example.loginsvl.exception.UncheckedException;
import com.example.loginsvl.utils.HibernateUtils;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

public class StudenDaoImpl implements StudentDao{
    Session session;

    @Override
    public List<Student> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            String query = " FROM Student";
            session.beginTransaction();
            List<Student> list = session.createQuery(query).getResultList();
            return list;
        }catch (Exception e){
            e.getStackTrace();
            return  null;
        }finally {
            session.close();
        }
    }


    @Override
    public Student createOrUpdate(Student student) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
           if (student.getId() == null){
               session.beginTransaction();
               session.save(student);
           }else {
               session.beginTransaction();
               session.update(student);
           }
           session.getTransaction().commit();
           return student;
        }catch (UncheckedException e){
            e.getStackTrace();
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }

    }

    @Override
    public Student delete(int id) {
        return null;
    }
}
