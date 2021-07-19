package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.simplilearn.util.HibernateUtil;
import com.simplilearn.model.User;


public class LoginDAO {
	
	Class<User> cls = com.simplilearn.model.User.class;
	
	public void save(User user) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory(user.getClass()).openSession()){
			transaction = session.beginTransaction();
			//save user object
				session.save(user);
				//commit transaction
				transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println("Something went wrong: "+e.getMessage());
		}
		
	}
	
	public boolean validateUser(String email, String pass) {
		Transaction transaction = null;
		User user = null;
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory(cls).openSession();
			transaction = sess.beginTransaction();
				user = (User) sess.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email).uniqueResult();
				if(user != null && user.getPassword().equals(pass)) {
					
					return true;
				}
				
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}finally {
			sess.close();

		}
		
		return false;
		
	}

	@SuppressWarnings("deprecation")
	public User getSingleUser(String email,String pass) {
		Transaction tranx = null;
		User user = null;
		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
			tranx  = session.beginTransaction();
	@SuppressWarnings("unchecked")
	Query<User> query = 
	session.createQuery("select firstname, lastname, gender, group from user u WHERE u.email=:email AND u.password=:password");

	query.setString("email",email);
	query.setString("pass", pass);
			return query.uniqueResult();
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public User getUser(String email,String pass) {
		Transaction transaction = null;
		Session session = null;
		User user = null;
		try{
			session = HibernateUtil.getSessionFactory(cls).openSession();
			transaction = session.beginTransaction();
				@SuppressWarnings("unchecked")
				Query<User> q = session.createQuery("FROM User U WHERE U.email = :email AND U.password =:pass ");
				q.setParameter("email", email);
				q.setParameter("pass",pass);
				user = q.uniqueResult();
				//user = (User)session.get(User.class, email);
				transaction.commit();
				session.close();
			return user;
		}catch(Exception e) {
			
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
		
		return user;
		
	}
	
	
	
}
