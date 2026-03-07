package com.cg.libraryManagementSystem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Author {
    @Id
    private int authorId;
    private String authorName;
    private String email;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> books;

    public Author() {}
    public Author(int authorId, String authorName, String email) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.email = email;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
