package com.example.firstservletapp.controllers;

import com.example.firstservletapp.entity.Employee;
import com.example.firstservletapp.dao.StudentDao;

import javax.servlet.RequestDispatcher;
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
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        List<Employee> employeeList = studentDao.studentList();
        req.setAttribute("studentList", employeeList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = new Employee();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        int idParam = Integer.parseInt(req.getParameter("id"));
        String nameParam = req.getParameter("name");
        employee.setId(idParam);
        employee.setName(nameParam);
        Employee newEmployee = studentDao.createOrUpdate(employee);
        PrintWriter printWriter = resp.getWriter();
        if (newEmployee != null) {
            printWriter.println("Id:" + newEmployee.getId() + "<br>");
            printWriter.println("Name:" + newEmployee.getName() + "<br>");
        } else {
            printWriter.println("Tạo thất bại");
        }
    }
}
