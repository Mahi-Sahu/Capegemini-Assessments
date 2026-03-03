package com.cg.pl;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

import java.sql.SQLOutput;

public class EmployeeMain {

	public static void main(String[] args) {
		IEmployeeService es=new EmployeeService();
		//String result=es.createEmployee(new Employee("Sejal", "sejal@gmail.com", "1984-07-26"));
		//String result=es.createEmployee(new Employee("Siya", "siya@gmail.com", "1982-10-29"));
		Employee emp1=es.findById("Har884");
		if(emp1!=null){
			System.out.println(emp1.getName());
			System.out.println(emp1.getEmail());
		}else{
			System.out.println("Employee Not Found");
		}
		//System.out.println(result);

	}

}
