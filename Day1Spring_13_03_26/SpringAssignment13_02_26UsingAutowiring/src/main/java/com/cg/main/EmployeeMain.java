package com.cg.main;

import com.cg.bean.Employee;
import com.cg.bean.SBU;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Employee emp = (Employee)context.getBean("employee");
        //employee details:
        System.out.println("Employee Details");
        System.out.println("-----------------------------");
        emp.employeeDeatils();

        //employee sbu details:
        System.out.println();
        emp.showEmployeeSBUDetails();

        //emplist:
        SBU sbu = (SBU)context.getBean("sbu");
        sbu.showSbuDetails();
        System.out.println();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter employee ID");
        int empid=sc.nextInt();
        List<Employee> employeeList=sbu.getEmpList();
        for(Employee e:employeeList){
            if(e.getEmpid()==empid){
                System.out.println("Employee Details");
                e.employeeDeatils();
            }
        }
    }
}
