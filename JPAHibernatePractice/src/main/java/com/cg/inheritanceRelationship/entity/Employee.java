package com.cg.inheritanceRelationship.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //if Table_per_class then it creates multiple tables-3 for each
//@DiscriminatorColumn(name = "Employee_type")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String employeeName;
    private LocalDate empDOB;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(LocalDate empDOB) {
        this.empDOB = empDOB;
    }
}
