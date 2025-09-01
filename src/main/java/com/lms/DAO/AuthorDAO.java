package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.Author;

public interface AuthorDAO {
    void addAuthor(Author author);
    Author getAuthorByID(int id);
    List<Author> getAllAuthors();
    void updateAuthor(Author author);
    void deleteAuthor(Author author);
}
