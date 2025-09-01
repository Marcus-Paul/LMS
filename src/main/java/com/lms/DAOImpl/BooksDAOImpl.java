package com.lms.DAOImpl;

import com.lms.DAO.BookDAO;
import com.lms.EntityClasses.Author;
import com.lms.EntityClasses.Book;
import com.lms.EntityClasses.Category;
import com.lms.util.HibernateUtil;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BooksDAOImpl implements BookDAO {


    @Override
    public void addBook(String bookName, int authID, String publishDate, int totalCopies, int availableCopies, int categoryID) {
    	Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	transaction = session.beginTransaction();
        	Author author = session.find(Author.class, authID);
			Category category = session.find(Category.class, categoryID);
			if (author == null || category == null) {
				throw new RuntimeException("Invalid Author ID or Category ID");
		    } else {
			Book book = new Book(bookName, author, publishDate, totalCopies, availableCopies, category);
            session.persist(book);
            transaction.commit();
            System.out.println("Book Added:" + book);
		    }
        } catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			throw new RuntimeException("Failed to add Book ", e);
		}
        
    }

    @Override
    public Book getBookById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
           
        	Book book = session.find(Book.class, id);
        	if(book!=null) {
        		System.out.println("Book Found "+book);
        		return book;
        	}  else {
        		System.out.println("No Book found by given ID");
        		return null;
        	}
        } catch (Exception e) {
			
			throw new RuntimeException("Failed to Retrieve Book with ID ", e);
		}

    }

    @Override
    public List<Book> getAllBooks() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Book", Book.class).list();
        } catch (Exception e) {	
			throw new RuntimeException("Failed to Retrieve Books ", e);
		}

    }

    @Override
    public void updateBook(int bookId, String bookName, int authID, String publishDate, int totalCopies, int availableCopies, int categoryID) {
    	Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	transaction = session.beginTransaction();
        	
        	Book existingBook = session.find(Book.class, bookId);
            if (existingBook == null) {
                throw new RuntimeException("No Book found with ID: " + bookId);
            }
        	
        	Author author = session.find(Author.class, authID);
			Category category = session.find(Category.class, categoryID);
			if (author == null || category == null) {
				throw new RuntimeException("Invalid Author ID or Category ID");
		    } else {
		    	existingBook.setBookName(bookName);
		        existingBook.setAuthor(author);
		        existingBook.setPublishDate(publishDate);
		        existingBook.setTotalCopies(totalCopies);
		        existingBook.setAvailableCopies(availableCopies);
		        existingBook.setCategory(category);

		        // Save updates
		        session.merge(existingBook);
		        transaction.commit();

		        System.out.println("Book has been updated: " + existingBook);
        	
        	
		    }           
        } catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	throw new RuntimeException("Failed to Update Book: ",  e);
        }
    }

    @Override
    public void deleteBook(Book book) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	tx = session.beginTransaction();
            Book attachedBook = session.find(Book.class, book.getBookId());
            if (attachedBook != null) {
                session.remove(attachedBook);
                tx.commit();
                System.out.println("Book Deleted: " + attachedBook);
            } else {
                System.out.println("Book not found with ID: " + book.getBookId());
            }

        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to Delete Book: ",  e);
        }
    }
}
