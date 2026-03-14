package com.cg.main;

import com.cg.bean.HelloWorld;
import com.cg.cfg.javaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(javaConfig.class);
        HelloWorld h=(HelloWorld)context.getBean("h");
        System.out.println(h.sayHello());
    }
}
