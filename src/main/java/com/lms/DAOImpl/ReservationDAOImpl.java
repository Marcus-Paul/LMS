package com.lms.DAOImpl;

import com.lms.DAO.ReservationDAO;
import com.lms.EntityClasses.Book;
import com.lms.EntityClasses.Member;
import com.lms.EntityClasses.Reservation;
import com.lms.EntityClasses.ReservationId;
import com.lms.util.HibernateUtil;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationDAOImpl implements ReservationDAO {
    
    @Override
    public void createReservation(int membershipId, int bookId) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Member member = session.find(Member.class, membershipId);
            Book book = session.find(Book.class, bookId);
            if(member==null || book==null) {
            	throw new RuntimeException("Invalid Book or Memeber");
            } else {
            	Reservation reservation = new Reservation(member, book);
            	session.persist(reservation);
            	tx.commit();
                System.out.println("Reservtion added: " + reservation);
            }
            
            
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to Create Reservation ", e);
        }
    }

    @Override
    public List<Reservation> getAllReservation() {
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
           return session.createQuery("from Reservation", Reservation.class).list();
        } catch (Exception e) {
        	throw new RuntimeException("Failed to Retrieve Reservation ", e);
		}
        
    }

    @Override
    public void updateReservation(int membershipId, int bookId, String status) {
    	Transaction tx = null;
    	
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	tx = session.beginTransaction();
        	ReservationId resId = new ReservationId(membershipId, bookId);
            Reservation reservation = session.find(Reservation.class, resId);

            if (reservation == null) {
                throw new RuntimeException("Reservation not found for member " + membershipId + " and book " + bookId);
            }
        	reservation.setStatus(status);
            session.merge(reservation);
            tx.commit();
            System.out.println("Reservation Updated: " + reservation);
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to Update Reservation ", e);
        }
    }

    @Override
    public void deleteReservation(int membershipId, int bookId) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            
            ReservationId reservationId = new ReservationId(membershipId, bookId);
            
            Reservation reservation = session.find(Reservation.class, reservationId);
            if (reservation == null) {
                System.out.println("No reservation found for member " + membershipId + " and book " + bookId);
            } else {
                session.remove(reservation);
                System.out.println("Reservation Deleted: " + reservation);
            }
             tx.commit();
             System.out.println("Reservation Deleted: " + reservation);
                          
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to Delete Reservation ", e);
        }
    }
}
