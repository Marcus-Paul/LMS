package com.lms.DAOImpl;

import com.lms.DAO.AuthorDAO;
import com.lms.EntityClasses.Author;
import com.lms.util.HibernateUtil;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDAOImpl implements AuthorDAO {
   
    @Override
    public void addAuthor(Author author) {
    	Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	transaction = session.beginTransaction();
        	session.persist(author);
        	transaction.commit();
        	System.out.println("Author added: " + author);
        } catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	throw new RuntimeException("Failed to add author: " + e.getMessage(), e);
        }

    }

    @Override
    public Author getAuthorByID(int id) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){   
        	
        	Author author = session.find(Author.class, id);
        	
            if (author != null){
            	System.out.println("Found Author: "+ author);
                return author;
            }
            else {
                System.out.println("No Authors Found with id : "+id);
            	return null;
            }
        } catch (Exception e) {
			throw new RuntimeException("Failed to retireve author with "+ id, e);
		}
    }

    @Override
    public List<Author> getAllAuthors() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            	return session.createQuery("from Author", Author.class).list();
            } catch (Exception e) {
    			throw new RuntimeException("Failed to retireve Authors ", e);
    		}
    }

    @Override
    public void updateAuthor(Author author) {
    	Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            
        	transaction = session.beginTransaction();
        	session.merge(author);
        	transaction.commit();
        	System.out.println("Author updated: " + author);

        } catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	throw new RuntimeException("Failed to Update author: " + e.getMessage(), e);
        }

    }

    @Override
    public void deleteAuthor(Author author) {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Author persistentAuthor = session.find(Author.class, author.getAuthorId());
            if (persistentAuthor != null) {
                session.remove(persistentAuthor);
                transaction.commit();
                System.out.println("Author Deleted: " + persistentAuthor);
            } else {
                System.out.println("Author not found with ID: " + author.getAuthorId());
                transaction.rollback();
            }
        } catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	throw new RuntimeException("Failed to Delete author: " + e.getMessage(), e);
        }
    }
}
