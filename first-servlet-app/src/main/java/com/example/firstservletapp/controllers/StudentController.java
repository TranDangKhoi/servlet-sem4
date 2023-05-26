package com.example.firstservletapp.controllers;

import com.example.firstservletapp.entity.Student;
import com.example.firstservletapp.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "student", value = "/student")
public class StudentController extends HttpServlet {
    StudentDao studentDao = new StudentDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        List<Student> studentList = studentDao.studentList();
        PrintWriter printWriter = resp.getWriter();
        if (studentList != null) {
            for (Student student : studentList
            ) {
                printWriter.println("Id:" + student.getId() + "<br>");
                printWriter.println("Name:" + student.getName() + "<br>");
            }
        } else {
            printWriter.println("Không có dữ liệu");
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Student student = new Student();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        int idParam = Integer.parseInt(req.getParameter("id"));
        String nameParam = req.getParameter("name");
        student.setId(idParam);
        student.setName(nameParam);
        Student newStudent = studentDao.createOrUpdate(student);
        PrintWriter printWriter = resp.getWriter();
        if (newStudent != null) {
            printWriter.println("Id:" + newStudent.getId() + "<br>");
            printWriter.println("Name:" + newStudent.getName() + "<br>");
        } else {
            printWriter.println("Tạo thất bại");
        }
    }
}
