package com.cg.libraryManagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Service {
    static EntityManager em;
    static{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        em = emf.createEntityManager();
    }
    public void create(String authorName,int authorId,String email){
        em.getTransaction().begin();
        Author author=new Author(authorId,authorName,email);
        Book b1=new Book("Java Fundamentals",450,author);
        Book b2=new Book("Advanced Java",650,author);
        Book b3=new Book("Java Streams",550,author);
        List<Book> books=new ArrayList<Book>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        author.setBooks(books);
        em.persist(author);
        em.getTransaction().commit();
    }

    public void read(List<Author> authors){
        em.getTransaction().begin();
        for(Author a:authors){
            System.out.println("Author Id : " + a.getAuthorId());
            System.out.println("Author Name : " + a.getAuthorName());
            System.out.println("-------------Books------------");

            for(Book b : a.getBooks()){
                System.out.println(b.getTitle() + " - " + b.getPrice());
            }
        }
        em.getTransaction().commit();
    }

    public void update(List<Book> books){
        em.getTransaction().begin();
        for(Book b : books){
            if(b.getTitle().equals("bookName")){
                System.out.println("Old price: " + b.getPrice());
                b.setPrice(700);
                System.out.println("New price: " + b.getPrice());
            }
        }
        em.getTransaction().commit();
    }

    public void deleteBook(List<Book> books,String bookName){
        em.getTransaction().begin();
        for(Book b : books){
            if(b.getTitle().equals(bookName)){
                em.remove(b);
                System.out.println("Book Removed");
                break;
            }
        }
        em.getTransaction().commit();
    }

    public void deleteAuthor(int authorId){
        em.getTransaction().begin();
        Author a4=em.find(Author.class,authorId);
        if(a4!=null){
            em.remove(a4);
            System.out.println("Author deleted successfully");
        }
        else
            System.out.println("Author not found");
        em.getTransaction().commit();
    }
}
