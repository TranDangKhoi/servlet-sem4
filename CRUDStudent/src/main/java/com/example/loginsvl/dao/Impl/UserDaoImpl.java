package com.example.loginsvl.dao.Impl;

import com.example.loginsvl.dao.UserDao;
import com.example.loginsvl.entity.User;
import com.example.loginsvl.exception.CheckedException;
import com.example.loginsvl.exception.UncheckedException;
import com.example.loginsvl.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.Arrays;

public class UserDaoImpl implements UserDao {
    Session session;
    @Override
    public User findByUserName(String username) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM User where username = :username";
            Query<User> query = session.createQuery(hql).setParameter("username",username);
            return query.getSingleResult();
        }catch (NoResultException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    @Override
    public User login(String username, String password) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM User where username = :username and password = :password";
            Query query = session.createQuery(hql).setParameter("username",username).setParameter("password",password);
            return (User) query.getSingleResult();
        }catch (NoResultException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    @Override
    public User register(User user) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return user;
        }catch (UncheckedException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }
}
