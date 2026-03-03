package com.jdbc.dao;

import com.jdbc.entity.Author;

public interface IAuthorDAO {

    void insertAuthor(Author author);

    void updateAuthor(int id, String phoneNo);

    void deleteAuthor(int id);

    void getAuthorById(int id);
}