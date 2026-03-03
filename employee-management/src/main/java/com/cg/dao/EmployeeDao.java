package com.cg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.bean.Employee;

public class EmployeeDao implements IEmployeeDao{
	private static Connection con;
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","MahiSahu2004");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String saveEmployee(Employee emp) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setString(1, emp.getEmpid());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getDob());
			int rows=ps.executeUpdate();
			if(rows>0)
				return "Employee Created";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Employee Not Created";
	}

	@Override
	public Employee findEmployee(String empid) {
		// TODO Auto-generated method stub
        try {
            PreparedStatement ps=con.prepareStatement("Select * from employee where empid=?");
			ps.setString(1,empid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return new Employee(
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("dob"));
			}

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee Not Found");
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		//get all employee details:
		List<Employee> list=new ArrayList<Employee>();
        try {
            PreparedStatement ps=con.prepareStatement("SELECT * FROM employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee emp=new Employee(
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("dob")
				);
				list.add(emp);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.isEmpty() ? null : list;
	}

	@Override
	public String updateEmployeeName(String empid, String newName) {
		// TODO Auto-generated method stub
		//update name of given employee
        try {
            PreparedStatement ps=con.prepareStatement("update employee set name=? where empid=?");
			ps.setString(1, newName);
			ps.setString(2, empid);
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "Employee Updated successfully";
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Employee not found or error in updating";
	}

	@Override
	public String deleteEmployee(String empid) {
		// TODO Auto-generated method stub
        try {
            PreparedStatement ps=con.prepareStatement("delete from employee where empid=?");
			ps.setString(1,empid);
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "Employee Deleted successfully";
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error in deleting employee";
	}

}
