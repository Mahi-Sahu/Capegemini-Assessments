package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    private int empid;
    private String empname;
    private double salary;
    private String bu;
    private int age;
    @Autowired
    private SBU sbu;

    public SBU getSbu() {
        return sbu;
    }

    public void setSbu(SBU sbu) {
        this.sbu = sbu;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void employeeDeatils(){
        System.out.println("Employee ID: "+empid);
        System.out.println("Employee Name: "+empname);
        System.out.println("Employee Salary: "+salary);
        System.out.println("Employee Bu: "+bu);
        System.out.println("Employee Age: "+age);
    }

    public void showEmployeeSBUDetails(){
        System.out.println("Employee Details");
        System.out.println("---------------------");
        System.out.println("Employee [empName="+empname+", empId="+empid+", empSalary="+salary
        +", sbu details= SBU[ sbuCode="+sbu.getSbuCode()+", sbuHead="+sbu.getSbuHead()+", sbuName="+sbu.getSbuName()+"]]");
    }
}
