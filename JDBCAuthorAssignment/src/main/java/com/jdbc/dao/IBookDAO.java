package com.jdbc.dao;

public interface IBookDAO {

    void insertBook(String title, double price, int authorId);

    void getBooksByAuthorName(String firstName);

    void updateBookPriceByAuthor(String firstName, double newPrice);
}