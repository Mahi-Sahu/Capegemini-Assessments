package com.cg.EmployeeDept_OneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deptId;
    private String deptName;
    private String location;
    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    List<Employees> employees;

    public Dept() {
    }
    public Dept(String deptName, String location) {
        this.deptName = deptName;
        this.location = location;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }
}
