package com.cg.EmployeeDept_OneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class DepartmentMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dept department = new Dept("Development","Noida");
        List<Employees> employees = new ArrayList<>();
        employees.add(new Employees("Harry",department));
        employees.add(new Employees("Sejal",department));
        department.setEmployees(employees);
        em.persist(department);
        em.getTransaction().commit();


    }

}
