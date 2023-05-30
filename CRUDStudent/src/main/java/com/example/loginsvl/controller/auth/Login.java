package com.example.loginsvl.controller.auth;

import com.example.loginsvl.dao.Impl.UserDaoImpl;
import com.example.loginsvl.dao.UserDao;
import com.example.loginsvl.entity.User;
import com.example.loginsvl.exception.UncheckedException;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login",value = "/login")
public class Login  extends HttpServlet {
    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username= req.getParameter("username");
            String password= req.getParameter("password");
            User user = userDao.findByUserName(username);
            boolean check = BCrypt.checkpw(password,user.getPassword());
            if(check == true){
                HttpSession session = req.getSession();
                session.setAttribute("user",username);
                req.removeAttribute("fail");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else {
                req.setAttribute("fail", "Username or password invalid!!!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }catch (UncheckedException e){
            log(e.getMessage());
        }
    }


}
