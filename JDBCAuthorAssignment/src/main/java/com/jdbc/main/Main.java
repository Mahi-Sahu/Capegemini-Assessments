package com.jdbc.main;

import com.jdbc.dao.AuthorDAO;
import com.jdbc.dao.BookDAO;
import com.jdbc.dao.IAuthorDAO;
import com.jdbc.dao.IBookDAO;
import com.jdbc.entity.Author;

public class Main {

    public static void main(String[] args) {

        IAuthorDAO authorDAO = new AuthorDAO();
        IBookDAO bookDAO = new BookDAO();

        // Insert Author
        Author author = new Author(1,"Rahul", "Sharma", "9876543210");
        authorDAO.insertAuthor(author);

        // Insert Book
        bookDAO.insertBook("Java Basics", 499.0, 1);

        // Get Author
        authorDAO.getAuthorById(1);

        // Get Books by Author
        bookDAO.getBooksByAuthorName("Rahul");

        // Update Price
        bookDAO.updateBookPriceByAuthor("Rahul", 599.0);
    }
}
