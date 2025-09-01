package com.lms.DAOImpl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lms.DAO.UserDAO;
import com.lms.EntityClasses.Member;
import com.lms.EntityClasses.Role;
import com.lms.EntityClasses.User;
import com.lms.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	

	
	public void createUser(String userEmail, String userPassword, int membershipId, boolean enabled, int roleId) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			
			Member member = session.find(Member.class, membershipId);
			if(member==null) {
				throw new RuntimeException("No Member found with Given ID" + membershipId);
			}
			
			Role role = session.find(Role.class, roleId);
			if(role==null) {
				throw new RuntimeException("No Role found with Given ID" + roleId);
			}
			
			User user = new User(userEmail, userPassword, member, enabled, new HashSet<>());
	        user.getRoles().add(role);
			
			
			
			session.persist(user);
			tx.commit();
			System.out.println("User Added");
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to create New User ", e);
		}
		
	}

	@Override
	public List<User> getAllUser() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from User", User.class).list();
				
		}  catch (Exception e) {
			throw new RuntimeException("Failed Fetch all Roles ", e);
		}
	}

	@Override
	public void updateUser(int userId, String userEmail, String userPassword, int membershipId, boolean enabled, int roleId) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			
			User user = session.find(User.class, userId);
			if(user==null) {
				throw new RuntimeException("No User Foound with ID" + userId);
			} else {
				Member member = session.find(Member.class, membershipId);
				if(member==null) {
					throw new RuntimeException("No Member found with Given ID" + membershipId);
				}
				
				Role role = session.find(Role.class, roleId);
				if(role==null) {
					throw new RuntimeException("No Role found with Given ID" + roleId);
				}
				
				Set<Role> roles = new HashSet<Role>();
				
				roles.add(role);
				
				user.setEmail(userEmail);
				user.setPassword(userPassword);
				user.setMember(member);
				user.setEnabled(enabled);
				user.setRoles(roles);
			}
			
			session.merge(user);
			tx.commit();
			System.out.println("Role Updated");
			
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to Update User ", e);
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			User attachedUser = session.find(User.class, userId);
			
			if(attachedUser!=null) {
				session.remove(attachedUser);
				tx.commit();
				System.out.println("User Deleted");
			} else {
				System.out.println("No User found to delete");
			}
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to Delete User ", e);
		}
		
	}

}
