package com.cg.main;

import com.cg.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        //initialise IOC container:
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld helloWorld1 = (HelloWorld)context.getBean("hello");
        HelloWorld helloWorld2 = (HelloWorld)context.getBean("hello");
        /*
        System.out.println(helloWorld1.sayHello("Mahi"));
        System.out.println(helloWorld2.sayHello("Ashi"));

        //ioc container by default creates a single object
        System.out.println(helloWorld1==helloWorld2); //returns true

         /*

        //changing objects: change in XML: scope="prototype"
        //helloWorld1.setName("Joe");
        //if not set by default Mahi(setter injection)
        */

        System.out.println(helloWorld1.sayHello());
        System.out.println(helloWorld1.getLanguage());
        ((ClassPathXmlApplicationContext)context).close();
    }
}
