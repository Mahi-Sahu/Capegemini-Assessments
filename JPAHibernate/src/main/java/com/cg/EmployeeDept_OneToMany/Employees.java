package com.cg.EmployeeDept_OneToMany;

import jakarta.persistence.*;

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String empName;
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Dept dept;

    public Employees() {}
    public Employees(String empName, Dept dept) {
        this.empName = empName;
        this.dept = dept;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
