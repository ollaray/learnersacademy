package com.simplilearn.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.util.HibernateUtil;
import com.simplilearn.model.User;


public class LoginDAO {
	Class<User> cls = com.simplilearn.model.User.class;
	public void save(User user) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
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
		
		try {
			Session sess = HibernateUtil.getSessionFactory(cls).openSession();
			transaction = sess.beginTransaction();
				user = (User) sess.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email).uniqueResult();
				if(user != null && user.getPassword().equals(pass)) {
					return true;
				}
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return false;
		
	}
	
	
}
