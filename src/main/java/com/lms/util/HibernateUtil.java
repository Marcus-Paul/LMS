package com.lms.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lms.EntityClasses.Author;
import com.lms.EntityClasses.Book;
import com.lms.EntityClasses.Category;
import com.lms.EntityClasses.Member;
import com.lms.EntityClasses.Reservation;
import com.lms.EntityClasses.Role;
import com.lms.EntityClasses.Transactions;
import com.lms.EntityClasses.User;



public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static {
		try {
            Configuration configuration = new Configuration().configure();
            
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Member.class);
            configuration.addAnnotatedClass(Reservation.class);
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(Transactions.class);
            configuration.addAnnotatedClass(User.class);
            
            sessionFactory = configuration.buildSessionFactory();
            
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed." + ex);
        }
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
