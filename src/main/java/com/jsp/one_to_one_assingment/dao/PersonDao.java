package com.jsp.one_to_one_assingment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_one_assingment.dto.Pan;
import com.jsp.one_to_one_assingment.dto.Person;

public class PersonDao {
	
	EntityManager entityManager = Persistence.createEntityManagerFactory("mayur").createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	//save person pan method
	public void savePanPerson(Pan pan , Person person)
	{
		entityTransaction.begin();
		entityManager.persist(pan);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	//method for getBYId
	public Person getPersonById(int personId)
	{
		entityManager = Persistence.createEntityManagerFactory("mayur").createEntityManager();
		
		Person person = entityManager.find(Person.class, personId);
		
		if(person != null)
		{
			return person;
		}
		else
		{
			return null;
		}
	}
	
	
	//method for delete
	public void deletePersonPanId(int personId)
	{
		entityManager = Persistence.createEntityManagerFactory("mayur").createEntityManager();
		
		entityTransaction = entityManager.getTransaction();
		
		Person person = entityManager.find(Person.class, personId);
		
		if(person != null) {
			
			Pan pan = person.getPan();
			
			entityTransaction.begin();
			entityManager.remove(person);
			entityManager.remove(pan);
			entityTransaction.commit();
			
			System.out.println("::::::::DATA::::::DELETED:::::::");
		}
	}
	
	//method for display
	public List<Person> getAllPersonPan()
	{
		String displayQuery= "SELECT p FROM Person p";
		
		Query query = entityManager.createQuery(displayQuery);
		
		List<Person> list = query.getResultList();
		
		return list;
				
	}
	
	//method for update
	public void updatePersonPan(int personId, String personName, String DOB)
	{
		Person person = getPersonById(personId);
		
		if(person != null)
		{
			Pan pan = person.getPan();
			
			if(pan != null)
			{
				pan.setDOB(DOB);
			}
			person.setPersonName(personName);
			
			entityTransaction.begin();
			entityManager.merge(person);
			entityManager.merge(pan);
			entityTransaction.commit();
			
			System.out.println("********Data*********UPDATED");
		}
		
		
	}
	
	
}
