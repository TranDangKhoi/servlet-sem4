package com.example.loginsvl.controller;

import com.example.loginsvl.dao.StudenDaoImpl;
import com.example.loginsvl.dao.StudentDao;
import com.example.loginsvl.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "student",value = "/student")
public class StudentController extends HttpServlet {
    private StudentDao dao = new StudenDaoImpl();
    Student student ;
    List<Student> list;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        list = dao.findAll();
        if (list != null) {
            for (Student v: list) {
                writer.println("---------------------------------"+ "<br>");
                writer.println(v.getId() + "<br>");
                writer.println(v.getName()+ "<br>");
                writer.println(v.getAge()+ "<br>");
                writer.println(v.getAddress()+ "<br>");
            }
        }else {
            writer.println("Không có dữ liệu");
        }
        writer.println("<br><a href=\"student.jsp\">Add new student</a>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        student = new Student();
        student.setId(Integer.valueOf(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setAge(req.getParameter("age"));
        student.setAddress(req.getParameter("address"));
        dao.createOrUpdate(student);
        resp.sendRedirect("student");
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
