package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.model.Person;
import com.simplilearn.util.HibernateUtil;

public class PersonDAO<T> {
	
private Class<Person> cls = com.simplilearn.model.Person.class;
	
	public void save(Person<T> person) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
			transaction = session.beginTransaction();
			//save person object
				session.save(person);
				//commit transaction
				transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	public void updatePerson(Person<T> person) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
			transaction = session.beginTransaction();
				session.update(person);
				transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	public void deletePerson(int id) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
			transaction = session.beginTransaction();
				Person<T> person = session.get(Person.class, id);
				if(person != null) {
					session.delete(person);
					System.out.println("Person with the id "+id+" has been deleted!");
				}
				transaction.commit();
			session.close();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	public Person<T> getPerson(int id) {
		Transaction transaction = null;
		Person person = null;
		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
			transaction = session.beginTransaction();
				person = session.get(Person.class, id);
				transaction.commit();
			session.close();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return person;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Person<T>> getAllPersons(){
		Transaction transaction = null;
		List<Person<T>> allPersons = null;
		try(Session session = HibernateUtil.getSessionFactory(cls).openSession()){
			transaction = session.beginTransaction();
				allPersons = session.createQuery("from Person").getResultList();
				transaction.commit();
			session.close();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return allPersons;
				
	}
}
