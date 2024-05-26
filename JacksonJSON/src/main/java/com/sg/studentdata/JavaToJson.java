package com.sg.studentdata;

import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JavaToJson {

	public static void main(String args[]) throws JsonMappingException, IOException, JsonMappingException {
		
		Student student = new Student();
		student.setId(100);
		student.setName("Rumaesa");
		student.setMarks(90);
		
		Address address = new Address();
		address.setFlatno(102);
		address.setBuildingName("Arfat Mansion");
		address.setArea("Byculla");
		
		student.setAddress(address);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new java.io.File("Student.json"), student);
		
		System.out.println("Json Generated...");
		
	}
	
}
