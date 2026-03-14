package com.cg.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class TestCar {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Car c = (Car) context.getBean("car");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Engine Name:(Petrol or CNG) ");
        String eng = sc.next();
        System.out.print("Enter Tyre Choice:(MRF or JK) ");
        String tyre = sc.next();

        IEngine e = (IEngine) context.getBean(eng.toLowerCase());
        ITyre t = (ITyre) context.getBean(tyre.toLowerCase());

//        c.setName("Honda City"); //given using @Value now
        c.setEngine(e);
        c.setTyre(t);
        c.printCar();
    }
}
