package com.cg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDao implements IEmployeeDao{
	private static EntityManagerFactory emf;
	static {
		try{
			emf= Persistence.createEntityManagerFactory("my-pu");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public String saveEmployee(Employee emp) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(emp);
			em.getTransaction().commit();
			return "Employee created successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Employee Not Created";
	}

	@Override
	public Employee findEmployee(String empid) {
		// TODO Auto-generated method stub
        try {
            EntityManager em = emf.createEntityManager();
			Employee emp = em.find(Employee.class, empid);
			if(emp != null){
				return emp;
			}
		} catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Employee Not Found");
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		//get all employee details:
        try {
			EntityManager em = emf.createEntityManager();
			List<Employee> list=em.createQuery("select e from Employee e",Employee.class).getResultList();
            return list.isEmpty()?null:list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public String updateEmployeeName(String empid, String newName) {
		// TODO Auto-generated method stub
		//update name of given employee
        try {
			EntityManager em = emf.createEntityManager();
			Employee emp = em.find(Employee.class, empid);
			if(emp!=null){
				em.getTransaction().begin();
				emp.setName(newName);
				em.getTransaction().commit();
				return "Employee updated successfully";
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Employee not found or error in updating";
	}

	@Override
	public String deleteEmployee(String empid) {
		// TODO Auto-generated method stub
        try {
			EntityManager em = emf.createEntityManager();
			Employee emp = em.find(Employee.class, empid);
			if(emp!=null){
				em.getTransaction().begin();
				em.remove(emp);
				em.getTransaction().commit();
				return "Employee deleted successfully";
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error in deleting employee";
	}

}
