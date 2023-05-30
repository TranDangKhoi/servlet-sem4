package com.example.loginsvl.dao.Impl;

import com.example.loginsvl.dao.StudentDao;
import com.example.loginsvl.entity.Student;
import com.example.loginsvl.exception.UncheckedException;
import com.example.loginsvl.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;
import java.util.Queue;

public class StudenDaoImpl implements
    StudentDao {
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
    public Integer delete(int id) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete  from Student where id = :id").setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
            return query.getFirstResult();
        }catch (UncheckedException e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Student finById(int id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Student> found = session.createQuery(" FROM Student WHERE id = :id").setParameter("id",id);
            session.getTransaction().commit();
            return found.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Khong xoa duoc");

        }finally {
            session.close();
        }
    }
}
