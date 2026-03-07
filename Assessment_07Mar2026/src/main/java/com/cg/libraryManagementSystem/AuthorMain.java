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
        List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        em.getTransaction().begin();
        switch (choice){
            case 1:
                //create:
                Author author=new Author(101,"James Gosling","james@gmail.com");
                Book b1=new Book("Java Fundamentals",450,author);
                Book b2=new Book("Advanced Java",650,author);
                Book b3=new Book("Java Streams",550,author);
                List<Book> books=new ArrayList<Book>();
                books.add(b1);
                books.add(b2);
                books.add(b3);
                author.setBooks(books);
                em.persist(author);
                break;
            case 2:
                //read:
                for(Author a:authors){
                    System.out.println("Author Id : " + a.getAuthorId());
                    System.out.println("Author Name : " + a.getAuthorName());
                    System.out.println("-------------Books------------");

                    for(Book b : a.getBooks()){
                        System.out.println(b.getTitle() + " - " + b.getPrice());
                    }
                }
                break;
            case 3:
                //update:
                System.out.println("Enter Book name");
                String bookName=sc.nextLine();
                for(Author a:authors){
                    for(Book b : a.getBooks()){
                        if(b.getTitle().equals("bookName")){
                            System.out.println("Old price: " + b.getPrice());
                            b.setPrice(700);
                            System.out.println("New price: " + b.getPrice());
                        }
                    }
                }
                break;
            case 4:
                //delete
                System.out.println("Enter bookName");
                String book=sc.nextLine();
                for(Author a:authors){
                    for(Book b : a.getBooks()){
                        if(b.getTitle().equals("Java Streams")){
                            em.remove(b);
                            System.out.println("Book Removed");
                            break;
                        }
                    }
                }

                break;
            case 5:
                //delete author:
                System.out.println("Enter Author ID");
                int authorId=sc.nextInt();
                Author a4=em.find(Author.class,authorId);
                if(a4!=null){
                    em.remove(a4);
                    System.out.println("Author deleted successfully");
                }
                else
                    System.out.println("Author not found");
                break;
            default: System.out.println("Invalid choice");
        }
        em.getTransaction().commit();



    }
}
