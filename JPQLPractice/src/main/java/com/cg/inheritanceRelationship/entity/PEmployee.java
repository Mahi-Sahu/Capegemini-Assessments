package com.cg.inheritanceRelationship.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("permanent-employee")
public class PEmployee extends Employee{
    private double salary;

    public PEmployee() {}
    public PEmployee(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
