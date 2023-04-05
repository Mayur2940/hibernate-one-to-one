package com.jsp.one_to_one_assingment.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Pan {
	
	@Id
	private String panNumber;
	private String DOB;
	private String fatherName;
}
