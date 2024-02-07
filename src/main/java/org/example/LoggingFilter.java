package org.example;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebFilter("/*")
public class LoggingFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Reuest @ " + new Date() + request.getRequestURL() + "started");
        if(request.getParameter("sessionId")!=null) {
            chain.doFilter(request, response);
            System.out.println(request.getRemoteAddr());
        }
        else {
            response.setStatus(403);
            response.getWriter().println("Not Permited");
        }
        System.out.println("Reuest @ " + new Date() + request.getRequestURL() + "ended");

    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
