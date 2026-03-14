package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emp")
public class Employee {
    @Value("${empid}")
    private String empid;
    @Value("${name}")
    private String name;
    @Autowired
    @Qualifier("add")
//    @Qualifier("add1") // in case of autowire="byType" and there are more than 2 bean of address it matches with id="add1"
    private Address address;

    public Employee() {}
    public Employee(String empid, String name, Address address) {
        this.empid = empid;
        this.name = name;
        this.address = address;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void printEmployeeDetails(){
        System.out.println("Employee id: "+empid);
        System.out.println("Name: "+name);
        System.out.println("=====Address====");
        System.out.println("City: "+address.getCity());
        System.out.println("Country: "+address.getCountry());
        System.out.println("Zip: "+address.getZip());
    }
}
