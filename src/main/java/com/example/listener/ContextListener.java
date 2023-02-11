package com.example.listener;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LocalDateTime servletTimeInit = LocalDateTime.now();
        sce.getServletContext().setAttribute("servletTimeInit", servletTimeInit);
    }
}
