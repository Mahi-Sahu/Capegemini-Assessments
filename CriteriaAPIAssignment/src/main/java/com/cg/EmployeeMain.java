package com.cg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();
        // 1. Obtain the CriteriaBuilder instance
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // 2. Create a CriteriaQuery object for an Object[] result type
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        // 3. Define the root entity from which to fetch data
        Root<Employee> root = cq.from(Employee.class);
        // 4. Select the department and the count of employees
        // Use multiselect to select multiple items (department and the aggregate count)
        cq.multiselect(
                root.get("dept"), // Selects the department object or field
                cb.count(root)         // Counts the number of Employee entities
        );
        cq.groupBy(root.get("dept"));

        // 5. Execute the query and retrieve the results
        TypedQuery<Object[]> typedQuery = em.createQuery(cq); //this stores[dept,count] of each object[] in list
        List<Object[]> results = typedQuery.getResultList();
        for(Object[] o: results){
            System.out.println(o[0]+"\t"+o[1]);
        }

    }
}
