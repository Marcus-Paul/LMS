package com.lms.DAOImpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lms.DAO.RoleDAO;
import com.lms.EntityClasses.Role;
import com.lms.util.HibernateUtil;

public class RoleDAOImpl implements RoleDAO {
	

	@Override
	public void createRole(Role role) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.persist(role);
			tx.commit();
			System.out.println("Role Created");
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to create New Role ", e);
		}
		
		
	}

	@Override
	public List<Role> getAllRoles() {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return session.createQuery("from Role", Role.class).list();
				
			}  catch (Exception e) {
				throw new RuntimeException("Failed Fetch all Roles ", e);
			}
			
	}


	@Override
	public void updateRole(Role role) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			Role existingRole = session.find(Role.class, role.getRoleId());
			if(existingRole!=null) {
				existingRole.setRoleName(role.getRoleName());
				session.merge(role);
			} else {
				System.out.println("No Role found with given ID" + role.getRoleId());
			}
			tx.commit();
			System.out.println("Role Updated");
			
			
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to Update Role ", e);
		}
		
	}

	@Override
	public void deleteRole(int roleId) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			tx = session.beginTransaction();
			Role attachedRole = session.find(Role.class, roleId);
			
			if(attachedRole!=null) {
				session.remove(attachedRole);
				tx.commit();
				System.out.println("Role Deleted");
			} else {
				System.out.println("No Role found to delete");
			}
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new RuntimeException("Failed to Delete Role ", e);
		}
		
	}

}
