package com.lms.DAOImpl;

import com.lms.DAO.CategoryDAO;
import com.lms.EntityClasses.Category;
import com.lms.util.HibernateUtil;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public void addCategory(Category category) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	tx = session.beginTransaction();
        	session.persist(category);
        	tx.commit(); 
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to add Category ", e);
        }
    }

    @Override
    public Category getCategoryByID(int id) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
           
        	Category category = session.find(Category.class, id);
        	if(category!=null) {
        		System.out.println(category);
        		return category;
        	}
        	else {
        		System.out.println("No Category found.");
        		return null;
        	} 	
        } catch(Exception e) {
        	throw new RuntimeException("Failed to Retrieve Category ", e);
        }
    }

    @Override
    public List<Category> getAllCategory() {
      
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Category", Category.class).list();
        } catch(Exception e) {
        	throw new RuntimeException("Failed to Retrieve Categorys ", e);
        }
        
    }

    @Override
    public void updateCategory(Category category) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
          tx = session.beginTransaction();
          session.merge(category);
          tx.commit();
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to Update Category ", e);
        }
    }

    @Override
    public void deleteCategory(Category category) {
    	Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Category attachedCategory = session.find(Category.class, category.getCategoryId());
            if (attachedCategory != null) {
                session.remove(attachedCategory);
                tx.commit();
                System.out.println("Category deleted");
            } else {
                System.out.println("No Category found");
                tx.rollback();
            }
          } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to Delete Category ", e);
        }
    }
}
