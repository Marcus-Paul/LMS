package com.lms.DAO;

import com.lms.TableClassess.Authors;

import java.util.List;

public interface AuthorsDAO {
    void addAuthor(Authors author);
    void getAuthorByID(int id);
    List<Authors> getAllAuthors();
    void updateAuthor(Authors author);
    void deleteAuthor(Authors author);
}
