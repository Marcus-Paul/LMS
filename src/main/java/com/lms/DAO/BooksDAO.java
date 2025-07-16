package com.lms.DAO;

import com.lms.TableClassess.Books;

import java.util.List;

public interface BooksDAO {
    void addBook(Books book);
    void getBookById(int id);
    List<Books> getAllBooks();
    void updateBook(Books book);
    void deleteBook(Books book);
}
