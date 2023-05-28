package com.example.loginsvl.utils;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtils {
    private static SessionFactory factory;
    private static EntityManagerFactory managerFactory;
    public static SessionFactory  getSessionFactory(){
        if (factory == null){
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
            }
        return factory;

    }

    public static EntityManagerFactory getManagerFactory(){
        if (managerFactory == null){
            managerFactory = Persistence.createEntityManagerFactory("jpaDemo");
        }
        return managerFactory;
    }
}
