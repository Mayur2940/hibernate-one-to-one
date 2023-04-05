package com.jsp.one_to_one_assingment.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.one_to_one_assingment.dto.Pan;
import com.jsp.one_to_one_assingment.dto.Person;
import com.jsp.one_to_one_assingment.service.PersonService;

public class PersonController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PersonService personService = new PersonService();
		
		System.out.println("1.Insert \n2. GetBYPersonId \n3. Delete \n4. Display \n5. Update");
		System.out.println("Enter Your Choice");
		int ch = sc.nextInt();
		
		switch (ch) {
		case 1: {
			
			Pan pan = new Pan();
			
			System.out.println("Enter Pan Number");
			pan.setPanNumber(sc.next());
			
			System.out.println("Enter Date Of Birth");
			pan.setDOB(sc.next());
			
			System.out.println("Enter Father Name");
			String fatherName = sc.next();
			fatherName += sc.nextLine();
			
			pan.setFatherName(fatherName);
			
			Person person = new Person();
			
			System.out.println("Enter Person Id");
			person.setPersonId(sc.nextInt());
			
			System.out.println("Enter Person Name");
			String personName = sc.next();
			personName+=sc.nextLine();
			
			person.setPersonName(personName);
			
			System.out.println("Enter Person Age");
			person.setPersonAge(sc.nextInt());
			
			person.setPan(pan);
			
			personService.savePanPerson(pan, person);
			
		}break;
		
		
		case 2: {
			
			System.out.println("Enter The Person Id");
			int id = sc.nextInt();
			
			Person person = personService.getPersonById(id);
			
			System.out.println(":::::::Person::::Details::::::");
			
			System.out.println("personId = " +person.getPersonId());
			System.out.println("personName = "+person.getPersonName());
			System.out.println("personAge = " +person.getPersonAge());
			
			System.out.println("::::::PAN:::::::Details::::::");
			
			System.out.println("personPAnNumber = "+person.getPan().getPanNumber());
			System.out.println("person DOB = "+person.getPan().getDOB());
			System.out.println("person Father Name = "+person.getPan().getFatherName());
		}break;
		
		case 3: {
			System.out.println("Enter Person Id for Delete");
			int id = sc.nextInt();
			
			personService.deletePersonPanId(id);
		}break;
		
		
		
		case 4: {
			
			List<Person> list = personService.getAllPersonPan();
			
			for (Person person : list) {
				
				 Pan pan = person.getPan();
				
				 if(pan != null)
				 {
					 System.out.println("::::::::::PAN:::::::DETAILS:::::::");
					 
					 System.out.println("personPAnNumber = "+person.getPan().getPanNumber());
					 System.out.println("person DOB = "+person.getPan().getDOB());
					 System.out.println("person Father Name = "+person.getPan().getFatherName());
					 
					 System.out.println(":::::::::PERSON::::::DETAILS::::::::");
					 
					 System.out.println("personId = " +person.getPersonId());
					 System.out.println("personName = "+person.getPersonName());
					 System.out.println("personAge = " +person.getPersonAge());
					 
					 System.out.println("==================================");
				 }
				
			}
		}break;
		
		case 5: {
			System.out.println("Enter the Person Id");
			int personId=sc.nextInt();
			
			System.out.println("Enter the Update name of Person");
			String name = sc.next();
			name += sc.nextLine();
			
			
			
			System.out.println("Enter the DOB to be Updated");
			String dob= sc.next();
			
			personService.updatePersonPan(personId, name, dob);
		}break;
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
	}
}
