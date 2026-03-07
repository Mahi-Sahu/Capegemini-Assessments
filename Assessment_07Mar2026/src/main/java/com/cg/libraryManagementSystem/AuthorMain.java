package com.cg.libraryManagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your operation choice: 1- CREATE, 2-READ, 3-UPDATE, 4-DELETE-BOOK, 5-DELETE AUTHOR");
        int choice = sc.nextInt();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em=emf.createEntityManager();
        List<Author> authors = em.createQuery("SELECT a FROM Author a",Author.class).getResultList();
        Service service = new Service();
        switch (choice){
            case 1:
                //create:
                System.out.println("Enter Author's Id: ");
                int authorId = sc.nextInt();
                System.out.println("Enter Author's mail: ");
                String email = sc.next();
                System.out.println("Enter Author's Name: ");
                String authorName = sc.next();
                service.create(authorName,authorId,email);
                break;
            case 2:
                //read:
                service.read(authors);
                break;
            case 3:
                //update:
                System.out.println("Enter Author's Id: ");
                int id=sc.nextInt();
                Author author = em.find(Author.class, id);
                List<Book> books = author.getBooks();
                service.update(books);
                break;
            case 4:
                //delete book
                System.out.println("Enter Author's Id: ");
                int id1=sc.nextInt();
                Author author1 = em.find(Author.class, id1);
                List<Book> booksList = author1.getBooks();
                System.out.println("Enter Book's Name: ");
                String nameBook=sc.nextLine();
                service.deleteBook(booksList,nameBook);
                break;
            case 5:
                //delete author:
                System.out.println("Enter Author's Id: ");
                int idAuthor=sc.nextInt();
                service.deleteAuthor(idAuthor);
        }



    }
}
