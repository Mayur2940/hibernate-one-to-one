package com.jsp.one_to_one_assingment.service;

import java.util.List;

import com.jsp.one_to_one_assingment.dao.PersonDao;
import com.jsp.one_to_one_assingment.dto.Pan;
import com.jsp.one_to_one_assingment.dto.Person;

public class PersonService {
	
	PersonDao personDao = new PersonDao();
	
	//save person pan method
		public void savePanPerson(Pan pan , Person person)
		{
			personDao.savePanPerson(pan, person);
		}
		
		//method for getBYId
		public Person getPersonById(int personId)
		{
			return personDao.getPersonById(personId);
		}
		
		//method for delete
		public void deletePersonPanId(int personId)
		{
			Person person = personDao.getPersonById(personId);
			
			if(person != null) 
			{
				if(person.getPan() != null) {
					personDao.deletePersonPanId(personId);
				}
				else
				{
					System.out.println("Pan is not Present for PersonId "+person.getPersonId());
				}
			}
			else
			{
				System.out.println("Person Id is NOt Present");
			}
		}
		
		//method for display
		public List<Person> getAllPersonPan()
		{
			return personDao.getAllPersonPan();
		}
		
		//method for update
		public void updatePersonPan(int personId, String personName, String DOB)
		{
			personDao.updatePersonPan(personId, personName, DOB);
		}
}
