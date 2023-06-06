package com.example.firstservletapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        System.out.println("Ket thuc");
    }

    @WebServlet("/UploadServlet")
    @MultipartConfig
    public class UploadServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Get the image file part
            Part filePart = request.getPart("imageFile");

            // Extract the file name
            String fileName = getFileName(filePart);

            // Save the file to the desired location on the local server
            String uploadPath = "D:\\Github\\servlet-sem4\\first-servlet-app\\target\\first-servlet-app-1.0-SNAPSHOT"; // Change this to your desired upload directory
            filePart.write(uploadPath + fileName);

            response.getWriter().println("Image uploaded successfully!");
        }

        // Extracts file name from HTTP header content-disposition
        private String getFileName(Part part) {
            String contentDisp = part.getHeader("content-disposition");
            String[] tokens = contentDisp.split(";");

            for (String token : tokens) {
                if (token.trim().startsWith("filename")) {
                    return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
                }
            }

            return "";
        }
    }


}