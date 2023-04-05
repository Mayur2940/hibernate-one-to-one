package com.jsp.one_to_one_assingment.dto;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data

public class Person {
	
	@Id
	private int PersonId;
	private String PersonName;
	private int PersonAge;
	
	@OneToOne
	private Pan pan;
}
