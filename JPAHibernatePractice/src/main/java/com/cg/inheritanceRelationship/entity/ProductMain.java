package com.cg.inheritanceRelationship.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        /*
        TypedQuery<Product> q = em.createQuery("Select p from Product p", Product.class);
        List<Product> products = q.getResultList();
        products.forEach(p -> System.out.println(p)); //@Data already gives overridden toString method

        //for reading only name:
        TypedQuery<String> q2 = em.createQuery("Select p.name from Product p", String.class);
        List<String> productNames = q2.getResultList();
        productNames.forEach(p -> System.out.println(p));

        //for reading multiple columns:
        //method-1
        TypedQuery<Object[]> q3 = em.createQuery("Select p.name,p.price,p.mfd from Product p", Object[].class);
        List<Object[]> list = q3.getResultList();

        for(Object[] obj : list){
            String name = (String) obj[0];
            int price = (Integer) obj[1];
            LocalDate mfd = (LocalDate) obj[2];
            System.out.println(name + " " + price + " " + mfd);
        }

        //method-2:
        TypedQuery<ProductDTO> q4 = em.createQuery("Select new ProductDTO(p.name,p.price,p.mfd) from Product p", ProductDTO.class);
        List<ProductDTO> productDTOs = q4.getResultList();
        productDTOs.forEach(System.out::println);

        //RETRIEVE USING CONDITION USING NAMED PARAMETER:
        TypedQuery<Product> q5 = em.createQuery("Select p from Product p where p.price<:p", Product.class);
        q5.setParameter("p", 75000); //price less than 75000 as :p is used in query
        List<Product> products5 = q5.getResultList();
        products5.forEach(System.out::println);

        TypedQuery<Product> q6= em.createQuery("Select p from Product p where p.name like :a", Product.class);
        q6.setParameter("a","L%");
        List<Product> products6 = q6.getResultList();
        products6.forEach(System.out::println);

         */

        //data manipulation:
        em.getTransaction().begin();
        Query query = em.createQuery("update Product p set p.price=65000 where p.pid=103");
        int row=query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Updated "+row+" rows");
    }
}
