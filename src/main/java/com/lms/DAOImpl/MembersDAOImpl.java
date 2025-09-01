package com.lms.DAOImpl;

import com.lms.DAO.MemberDAO;
import com.lms.EntityClasses.Member;
import com.lms.util.HibernateUtil;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MembersDAOImpl implements MemberDAO {


    @Override
    public void newMembership(Member member) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(member);
            tx.commit();
            System.out.println("New Member added: " + member);
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to update Member ", e);
        }
    }

    @Override
    public Member getMemberByID(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Member member = session.find(Member.class, id);
            if(member!=null) {
            	System.out.println(member);
            	return member;
            }
            else {
            	System.out.println("No Member found with the given ID");
            	return null;
            }     
        } catch(Exception e) {
        	throw new RuntimeException("Failed to fetch Member ", e);
        }
    }

    @Override
    public List<Member> getAllMembers() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	return session.createQuery("from Member", Member.class).list();
        } catch(Exception e) {
        	throw new RuntimeException("Failed to fetch Members ", e);
        }
    }

    @Override
    public void updateMember(Member member) {
    	Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        	tx = session.beginTransaction();
            session.merge(member);
            tx.commit();
            System.out.println("New Member Updated: " + member);
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to update Member ", e);
        }
    }

    @Override
    public void deleteMember(Member member) {
    	Transaction tx = null;
    	try(Session session = HibernateUtil.getSessionFactory().openSession()){
    		
    		Member attachedMembers = session.find(Member.class, member.getMembershipId());
    		if(attachedMembers!=null) {
    			tx = session.beginTransaction();
                session.remove(attachedMembers);
                tx.commit();
                System.out.println("Member Deleted: " + attachedMembers);
    		} else {
    			System.out.println("No Member found with the given ID");
    		}
    		
        } catch(Exception e) {
        	if(tx!=null) {
        		tx.rollback();
        	}
        	throw new RuntimeException("Failed to update Member ", e);
        }

    }
}
