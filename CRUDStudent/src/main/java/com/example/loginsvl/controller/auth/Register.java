package com.example.loginsvl.controller.auth;

import com.example.loginsvl.dao.Impl.UserDaoImpl;
import com.example.loginsvl.dao.UserDao;
import com.example.loginsvl.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {
  private final UserDao userDao = new UserDaoImpl();
  User user = new User();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.sendRedirect("register.jsp");
  }

  @Override
  protected void doPost( HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    String username  = req.getParameter("username").toLowerCase();
    String password = req.getParameter("password");
    String confirmPassword = req.getParameter("confirm");
    user =  userDao.findByUserName(username);

    if(user == null && password.equals(confirmPassword)){
      String gensalt = BCrypt.gensalt();
      String passwordEncode = BCrypt.hashpw(password.trim(),gensalt);
      userDao.register(new User(username,passwordEncode));
      req.removeAttribute("username");
      req.setAttribute("user",username);
      resp.sendRedirect("index.jsp");
    }
    if (!password.equals(confirmPassword)) req.setAttribute("password","password does not match confirm password");
    req.setAttribute("username","Username already exist");
    req.getRequestDispatcher("register.jsp").forward(req,resp);
  }
}
