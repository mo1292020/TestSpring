package org.example;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       System.out.println("Context Request destroy");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextRequest destroy");    }
}
