package com.cg.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("sbu")
public class SBU {
    final private String sbuCode="PES-BU";
    @Value("${sbuId}")
    private int sbuId;
    @Value("${sbuName}")
    private String sbuName;
    @Value("${sbuHead}")
    private String sbuHead;
//    private List<Employee> empList;

    public int getSbuId() {
        return sbuId;
    }

//    public List<Employee> getEmpList() {
//        return empList;
//    }

//    public void setEmpList(List<Employee> empList) {
//        this.empList = empList;
//    }

    public String getSbuCode() {
        return sbuCode;
    }

    public void setSbuId(int sbuId) {
        this.sbuId = sbuId;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public void showSbuDetails(){
        System.out.println("SBU Details");
        System.out.println("---------------");
        System.out.println("sbuCode="+sbuCode+", sbuName="+sbuName+", sbuHead="+sbuHead);
        System.out.println("Employee Deatils:----------");
        System.out.print("Employee [");
//        for(Employee emp:empList){
//            emp.employeeDeatils();
//            System.out.print("]\n");
//        }
    }
}
