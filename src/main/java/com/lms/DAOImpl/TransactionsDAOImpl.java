package com.lms.DAOImpl;


import com.lms.DAO.TransactionsDAO;
import com.lms.EntityClasses.Book;
import com.lms.EntityClasses.Member;
import com.lms.EntityClasses.Transactions;
import com.lms.util.HibernateUtil;

import org.hibernate.Transaction;
import java.util.List;

import org.hibernate.Session;

public class TransactionsDAOImpl implements TransactionsDAO {


    @Override
    public void addTransaction(int membershipId,int bookId) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Member member = session.find(Member.class, membershipId);
            Book book = session.find(Book.class, bookId);
            
            if(book==null || member==null) {
            	throw new RuntimeException("Invalid Member or Book ID");
            } else {
            	Transactions transaction = new Transactions(member, book);
            	session.persist(transaction);
                tx.commit();
            }
            

        } catch (Exception e) {
        	
        	if(tx!=null) {
        		tx.rollback();
        	}
        	
            throw new RuntimeException("Failed to Add Transaction", e);
        }

    }

    @Override
    public Transactions getTransactionByID(int id) {
    	
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
        	Transactions attachedTransaction =  session.find(Transactions.class, id);
        	if(attachedTransaction!=null) {
        		System.out.println("Found the Transaction");
        		return attachedTransaction;
        	} else {
        		System.out.println("No Transaction found with the given ID");
        		return null;
        	}    	

        } catch (Exception e) {
            throw new RuntimeException("Failed to Get Transaction By given ID", e);
        }

    }

    @Override
    public Transactions getTransactionByMembershipIdBookId(int membershipId, int bookId) {
    	
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            
        	String hql = "from Transactions t where t.member.membershipId = :membershipId and t.book.bookId = :bookId";
        	Transactions tx = session.createQuery(hql, Transactions.class).setParameter("membershipId", membershipId).setParameter("bookId", bookId).uniqueResult();
        	return tx;
        	
        	
        } catch (Exception e) {
        	throw new RuntimeException("Failed to Get Transaction By given Membership ID & Book ID", e);
        }
    }

    @Override
    public List<Transactions> listOfTransactions() {
    	try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Transactions", Transactions.class).list();
        } catch (Exception e) {
        	throw new RuntimeException("Failed to Get All the Transactions", e);
        }

    }

    @Override
    public void updateTransaction(Transactions transaction) {
    	Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			session.merge(transaction);
			tx.commit();
			System.out.println("Transaction Updated");
			
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to Update Transaction ", e);
		}
    }

    @Override
    public void deleteTransaction(Transactions transaction) {
    	Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			Transactions attachedTransactions = session.find(Transactions.class, transaction.getTransactionId());
			
			if(attachedTransactions!=null) {
				session.remove(attachedTransactions);
				tx.commit();
				System.out.println("Transaction Deleted");
			} else {
				System.out.println("No Transaction found to delete");
			}
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to Delete Transaction", e);
		}
    }

}
