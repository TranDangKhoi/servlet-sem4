package com.example.loginsvl.controller;

import com.example.loginsvl.dao.Impl.StudenDaoImpl;
import com.example.loginsvl.dao.StudentDao;
import com.example.loginsvl.entity.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "student", value = "/student")
public class StudentController extends HttpServlet {
    private StudentDao dao = new StudenDaoImpl();
    Student student;
    List<Student> list;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        list = dao.findAll();
        req.setAttribute("listStudent", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method.equals("DELETE")) {
            Integer id = Integer.valueOf(req.getParameter("idStu"));
            Integer delete = dao.delete(id);
            if (delete != null) resp.sendRedirect("student");
        } else {

            student = new Student();
            Integer id = Integer.valueOf(req.getParameter("id"));
            if (id != null) student.setId(id);
            student.setName(req.getParameter("name"));
            student.setAge(req.getParameter("age"));
            student.setAddress(req.getParameter("address"));
            dao.createOrUpdate(student);

            resp.sendRedirect("student");
        }
    }

}
