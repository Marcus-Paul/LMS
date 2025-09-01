package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.Book;

public interface BookDAO {
    void addBook(String bookName, int authID, String publishDate, int totalCopies, int availableCopies, int categoryID);
    Book getBookById(int id);
    List<Book> getAllBooks();
    void updateBook(int bookID, String bookName, int authID, String publishDate, int totalCopies, int availableCopies, int categoryID);
    void deleteBook(Book book);
}
