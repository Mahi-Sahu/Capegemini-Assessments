package com.cg.service;

import java.util.List;
import java.util.Random;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.IEmployeeDao;

public class EmployeeService implements IEmployeeService {
	IEmployeeDao dao=new EmployeeDao();
	
	@Override
	public String createEmployee(Employee emp) {
		if(emp.getName()==null || emp.getName().length()<4 || emp.getEmail()==null ) {
			return "Invalid Employee Data";
		}
		else {
			Random r=new Random();
			String empid=emp.getName().substring(0,3)+r.nextInt(1000);
			emp.setEmpid(empid);
			return dao.saveEmployee(emp);
		}
	}

	@Override
	public Employee findById(String eid) {
		// TODO Auto-generated method stub
		if(eid==null){
			return null;
		}
		return dao.findEmployee(eid);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public String updateEmployeeName(String eid, String name) {
		// TODO Auto-generated method stub
		if(eid==null || name==null || name.length()<3)
			return "Invalid data";
		return dao.updateEmployeeName(eid, name);
	}

	@Override
	public String removeEmployee(String empid) {
		// TODO Auto-generated method stub
		if(empid==null)
			return "Invalid Employee Data";
		return dao.deleteEmployee(empid);
	}

}
