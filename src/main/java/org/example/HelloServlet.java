package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(MediaType.TEXT_HTML);
        response.setStatus(201);
        String name = request.getParameter("name");
        if (name == null)
            name = "guest";
        response.getWriter().println("hello ya <b>" + name + "</b>");
        response.getWriter().println("<img src='book.jpg'/>");
        response.getWriter().println("<hr />");
        response.getWriter().println("copyright (c)");
        response.setHeader("my_test_hedears","test");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init method");
    }
}
