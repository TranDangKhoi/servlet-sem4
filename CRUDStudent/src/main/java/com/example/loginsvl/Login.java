package com.example.loginsvl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login",value = "/login")
public class Login  extends HttpServlet {
    private static  final String user= "admin";
    private static final String pass= "123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username= req.getParameter("username");
            String password= req.getParameter("password");
            if(username.equals(user)&& password.equals(pass)){
                HttpSession session = req.getSession();
                session.setAttribute("user",username);
                resp.sendRedirect("index.jsp");
            }
        }catch (Exception e){
            log(e.getMessage());
        }
    }


}
