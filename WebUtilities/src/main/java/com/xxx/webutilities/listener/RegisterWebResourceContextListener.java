package com.xxx.webutilities.listener;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RegisterWebResourceContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        final ClassGraph classGraph = new ClassGraph().enableClassInfo()
                .enableAnnotationInfo()
                .acceptPackages("com.xxx.*.internal.properties")
                .addClassLoader(classLoader);
        ScanResult scanResult = classGraph.verbose().scan();
        System.out.println("From Thread.currentThread().getContextClassLoader()");
        System.out.println("All Classes from Scan Result:" + scanResult.getAllClasses().toString());
        scanResult.getAllClasses().loadClasses();

        final ClassGraph classGraphServlet = new ClassGraph().enableClassInfo()
                .enableAnnotationInfo()
                .acceptPackages("com.xxx.web.*");
        ScanResult scanResultServlet = classGraphServlet.scan();
        System.out.println("From servletContextEvent.getServletContext().getClassLoader()");
        System.out.println("All Classes from Scan Result:" + scanResultServlet.getAllClasses().toString());
        scanResultServlet.getAllClasses().loadClasses();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context Destroyed");
    }
}
