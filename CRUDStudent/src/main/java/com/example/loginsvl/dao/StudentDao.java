package com.example.loginsvl.dao;

import com.example.loginsvl.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student createOrUpdate(Student student);
    Integer delete(int id);
    Student finById(int id);
}
