package com.example.loginsvl.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/hello-servlet","/upload","/","/student"})
public class AuthenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        int status = res.getStatus();
        if(status == 404) res.sendRedirect("notfound.jsp");
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        String uri = req.getRequestURI();
        String url  = req.getRequestURL().toString();
        if(user == null && !uri.equals("jsp")&& !url.equals("login")){

            res.sendRedirect("login.jsp");
        }else {
            filterChain.doFilter(req,res);
        }

    }


    @Override
    public void destroy() {

    }
}
