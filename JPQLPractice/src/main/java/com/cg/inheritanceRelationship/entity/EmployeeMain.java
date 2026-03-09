package com.cg.inheritanceRelationship.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.Month;

public class EmployeeMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PEmployee pEmployee = new PEmployee();
        pEmployee.setEmployeeName("Jack");
        pEmployee.setSalary(50000);
        pEmployee.setEmpDOB(LocalDate.of(1990, Month.JANUARY, 1));
        em.persist(pEmployee);

        CEmployee cemployee = new CEmployee();
        cemployee.setEmployeeName("Michael");
        cemployee.setEmpDOB(LocalDate.of(1990, Month.APRIL, 1));
        cemployee.setPay_per_hour(5000);
        em.persist(cemployee);
        em.getTransaction().commit();
    }
}
