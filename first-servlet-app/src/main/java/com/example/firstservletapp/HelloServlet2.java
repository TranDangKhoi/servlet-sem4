package com.example.firstservletapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/xin-chao2", "/hello2"})
public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getContextPath();
        req.getContentType();
        Enumeration<String> keys = req.getHeaderNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + ":" + req.getHeader(key));
        }
    }
}
