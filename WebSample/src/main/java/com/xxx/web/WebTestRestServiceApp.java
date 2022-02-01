package com.xxx.web;

import com.xxx.webutilities.TestRestServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class WebTestRestServiceApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();
        resources.add(TestRestServiceImpl.class);
        return resources;
    }
}
